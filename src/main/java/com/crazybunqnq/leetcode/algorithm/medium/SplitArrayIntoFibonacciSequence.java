package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 * <p>
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 * <p>
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 * <p>
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 * <p>
 * Example 1:
 * <p>
 * Input: "123456579"
 * Output: [123,456,579]
 * Example 2:
 * <p>
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * Example 3:
 * <p>
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * Example 4:
 * <p>
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 * Example 5:
 * <p>
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * S contains only digits.
 *
 * @version 2018/5/27.
 * @Score 6
 * @auther CrazyBunQnQ
 */
public class SplitArrayIntoFibonacciSequence {
    public final static int MAX = 2147483646;

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        int num1, num2, num3, sum, index;
        String str1, str2, str3;
        long tmp;
        for (int i = 1; i < 11; i++) {
            str1 = S.substring(0, i);
            tmp = Long.valueOf(str1);
            if (str1.indexOf("0") == 0 && str1.length() > 1 || tmp > MAX) {
                continue;
            }
            num1 = (int) tmp;
            for (int j = 1; j < 11; j++) {
                str2 = S.substring(i, i + j);
                tmp = Long.valueOf(str2);
                if (str2.indexOf("0") == 0 && str2.length() > 1 || tmp + num1 > MAX) {
                    continue;
                }
                num2 = (int) tmp;
                sum = num1 + num2;
                str3 = String.valueOf(sum);
                if (i + j + str3.length() > S.length()) {
                    continue;
                }
                if (S.substring(i + j, i + j + str3.length()).equals(str3)) {
                    if (list.indexOf(num1) == -1) {
                        list.add(num1);
                    }
                    if (list.indexOf(num2) == -1) {list.add(num2);}
                    list.add(sum);
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        int i = (int) Math.pow(2, 31) * 2;
        System.out.println(String.valueOf(i).length());
        double j = Math.pow(2, 31) * 2;
        System.out.println(i + "\n" + j);
    }
}
