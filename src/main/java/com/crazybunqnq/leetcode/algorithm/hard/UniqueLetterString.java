package com.crazybunqnq.leetcode.algorithm.hard;

import com.crazybunqnq.util.TimeUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A character is unique in string S if it occurs exactly once in it.
 * <p>
 * For example, in string S = "LETTER", the only unique characters are "L" and "R".
 * <p>
 * Let's define UNIQ(S) as the number of unique characters in string S.
 * <p>
 * For example, UNIQ("LETTER") =  2.
 * <p>
 * Given a string S, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
 * <p>
 * If there are two or more equal substrings at different positions in S, we consider them different.
 * <p>
 * Since the answer can be very large, retrun the answer modulo 10 ^ 9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * Example 2:
 * <p>
 * Input: "ABA"
 * Output: 8
 * Explanation: The same as example 1, except uni("ABA") = 1.
 * <p>
 * <p>
 * Note: 0 <= S.length <= 10000.
 *
 * @version 2018/5/6.
 * @Score 9
 * @auther CrazyBunQnQ
 */
public class UniqueLetterString {
    public int uniq(String S) {
        int size = 0;
        StringBuilder sb = new StringBuilder();
        Set<Character> subChars = new HashSet<Character>();
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            subChars.add(c);
            if (subChars.size() == size) {
                if (sb.indexOf(c + "") == -1) {
                    sb.append(sb.length() == 0 ? "[" + c : c);
                    if (sb.length() >= 27) {
                        break;
                    }
                }
            } else {
                size++;
            }
        }
        sb.append("]+");
        String rex = sb.toString();
        S = S.replaceAll(rex, "");
        return S.length();
    }

    public int uniqueLetterString(String S) {
        int result = S.length() == 1 ? 1 : S.length() + uniq(S);
        for (int length = 2; length < S.length(); length++) {
            for (int start = 0; start <= S.length() - length; start++) {
                String subS = S.substring(start, start + length);
                result += uniq(subS);
            }
        }
        return result;
    }

    public int uniqueLetterString1ms(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int[][] cnt = new int[26][2];
        for (int i = 0; i < 26; i++) {
            cnt[i][0] = -1;
            cnt[i][1] = -1;
        }
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            cnt[S.charAt(i) - 'A'][0] = cnt[S.charAt(i) - 'A'][1];
            cnt[S.charAt(i) - 'A'][1] = i;
            int tmp = 0;
            for (int j = 0; j < 26; j++) {
                tmp += (cnt[j][1] - cnt[j][0]);
            }
            sum += tmp;
        }
        return sum;
    }

    /**
     * Intuition:
     * <p>
     * Let's think about how a character can be found as a unique character.
     * <p>
     * Think about string "XAXAXXAX" and focus on making the second "A" a unique character.
     * <p>
     * We can take "XA(XAXX)AX" and between "()" is our substring.
     * <p>
     * We can see here, to make the second "A" counted as a uniq character, we need to:
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;1.insert "(" somewhere between the first and second A
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;2.insert ")" somewhere between the second and third A
     * <p>
     * For step 1 we have "A(XA" and "AX(A", 2 possibility.
     * <p>
     * For step 2 we have "A)XXA", "AX)XA" and "AXX)A", 3 possibilities.
     * <p>
     * So there are in total 2 * 3 = 6 ways to make the second A a unique character in a substring.
     * <p>
     * In other words, there are only 6 substring, in which this A contribute 1 point as unique string.
     * <p>
     * Instead of counting all unique characters and struggling with all possible substrings,
     * <p>
     * we can count for every char in S, how many ways to be found as a unique char.
     * <p>
     * We count and sum, and it will be out answer.
     * <p>
     * <p>
     * Explanation:
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;1.index[26][2] record last two occurrence index for every upper characters.
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;2.Initialise all values in index to -1.
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;3.Loop on string S, for every character c, update its last two occurrence index to index[c].
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;4.Count when loop. For example, if "A" appears twice at index 3, 6, 9 seperately, we need to count:
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For the first "A": (6-3) * (3-(-1))"
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For the second "A": (9-6) * (6-3)"
     * <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For the third "A": (N-9) * (9-6)"
     * <p>
     * <p>
     * Complexity:
     * <p>
     * One pass, time complexity O(N).
     * <p>
     * Space complexity O(1).
     *
     * @param S
     *
     * @return
     */
    public int uniqueLetterString0ms(String S) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1);
        int res = 0, N = S.length(), mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[]{index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }

    @Test
    public void test() {
        System.out.println("A: " + uniqueLetterString("A"));
        System.out.println("ABC: " + uniqueLetterString("ABC"));
        System.out.println("ABCD: " + uniqueLetterString("ABCD"));
        System.out.println("ABA: " + uniqueLetterString("ABA"));
        System.out.println("ABCDFFEMQQQQNA: " + uniqueLetterString("ABCDFFEMQQQQNA"));
        TimeUtil.setCurrentTime();
        System.out.println(uniqueLetterString0ms("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU") + "  耗时 " + TimeUtil.runTime() + " 毫秒");
        System.out.println();
    }
}
