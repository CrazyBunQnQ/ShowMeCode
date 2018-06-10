package com.crazybunqnq.leetcode.algorithm.medium;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 * <p>
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * <p>
 * Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
 * <p>
 * Return the final string after all such shifts to S are applied.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation:
 * We start with "abc".
 * After shifting the first 1 letters of S by 3, we have "dbc".
 * After shifting the first 2 letters of S by 5, we have "igc".
 * After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 * Note:
 * <p>
 * 1 <= S.length = shifts.length <= 20000
 * 0 <= shifts[i] <= 10 ^ 9
 *
 * @version 2018/6/10.
 * @Score 4
 * @auther CrazyBunQnQ
 */
@Log4j
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder(S);
        int sum = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            int index = length - i - 1;
            sum = (sum + shifts[index]) % 26;
            sb.setCharAt(index, shift(S.charAt(index), sum));
        }
        return sb.toString();
    }

    public char shift(char c, int n) {
//        n = n % 26;
//        System.out.println("n=" + n + "  n%26=" + (n % 26));
        int result = (int) c + n;
        if (result > 122)
            result -= 26;
        System.out.println(result + " " + (char) result);
        return (char) result;
    }

    @Test
    public void test() {
        System.out.println((int) 'a' + " " + (int) 'z');
        String[] strs = {"abc", "mkgfzkkuxownxvfvxasy"};
        int[][] ints = {{3, 5, 9}, {505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}
        };
        for (int i = 0; i < strs.length; i++) {
            System.out.println(shiftingLetters(strs[i], ints[i]));
        }
    }
}
