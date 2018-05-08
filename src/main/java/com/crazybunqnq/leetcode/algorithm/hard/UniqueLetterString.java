package com.crazybunqnq.leetcode.algorithm.hard;

import com.crazybunqnq.util.TimeUtil;
import org.junit.Test;

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

    @Test
    public void test() {
        System.out.println("A: " + uniqueLetterString("A"));
        System.out.println("ABC: " + uniqueLetterString("ABC"));
        System.out.println("ABCD: " + uniqueLetterString("ABCD"));
        System.out.println("ABA: " + uniqueLetterString("ABA"));
        System.out.println("ABCDFFEMQQQQNA: " + uniqueLetterString("ABCDFFEMQQQQNA"));
        TimeUtil.setCurrentTime();
        System.out.println(uniqueLetterString("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU") + "  耗时 " + TimeUtil.runTime() + " 毫秒");
        System.out.println();
    }
}
