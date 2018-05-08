package com.crazybunqnq.leetcode.algorithm.hard;

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
    public String[] getDittograms(String S) {
        int size = 0;
        StringBuilder sb = new StringBuilder();
        Set<Character> subChars = new HashSet<Character>();
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            subChars.add(c);
            if (subChars.size() == size) {
                if (sb.indexOf(c + "") == -1)
                    sb.append(sb.length() == 0 ? "[" + c : c);
            } else {
                size++;
            }
        }
        if (sb.length() > 0) {
            sb.append("]+");
            String rex = sb.toString();
            S = S.replaceAll(rex, "-");
        }
        return S.split("-");
    }

    /**
     * ABCD
     * <p>
     * 1+2+3+4 = 10
     * <p>
     * case A B C D AB BC CD ABC BCD ABCD
     * <p>
     * length 1*4 2*3 3*2 4*1
     */
    public int calLength(String subS) {
        int result = 0;
        for (int i = 0; i < subS.length(); i++) {
            result += (i + 1) * (subS.length() - i);
        }
        return result;
    }

    public int uniqueLetterString(String S) {
        int result = 0;
        String[] dittograms = getDittograms(S);
        for (int i = 0; i < dittograms.length; i++) {
            System.out.println(dittograms[i] + ":");
            result += calLength(dittograms[i]);
        }
        return result;
    }

    @Test
    public void test() {
        uniqueLetterString("ABC");
        uniqueLetterString("ABA");
        uniqueLetterString("ABCDFFEMQQQQNA");
    }
}
