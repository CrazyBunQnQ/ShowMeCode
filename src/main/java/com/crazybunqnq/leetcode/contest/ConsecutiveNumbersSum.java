package com.crazybunqnq.leetcode.contest;

import org.junit.Test;

/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * Note: 1 <= N <= 10 ^ 9.
 *
 * @version 2018/5/6.
 * @Score 7
 * @auther CrazyBunQnQ
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int result = 1;
        Integer n = N / 2 + 1;
        Integer a1an = 0;
        int[] sequence;
        boolean isBreak;

        while (n > 1) {
            isBreak = false;
            if (N * 2 % n != 0) {
                n--;
                continue;
            }
            a1an = N * 2 / n;
            int am = N / n;
            sequence = new int[n];
            if (N % n == 0) {
                //N/n 是中间数
                int m = (n - 1) / 2;
                sequence[m] = am;
                for (int i = m; i >= 1; i--) {
                    sequence[m - i] = am - i;
                    if (sequence[m - i] <= 0) {
                        isBreak = true;
                        break;
                    }
                    sequence[m + i] = am + i;
                }
            } else {
                int m1 = n / 2 - 1;
                int m2 = n / 2;
                sequence[m1] = am;
                sequence[m2] = am + 1;
                for (int i = m1; i >= 1; i--) {
                    sequence[m1 - i] = am - i;
                    if (sequence[m1 - i] <= 0) {
                        isBreak = true;
                        break;
                    }
                    sequence[m2 + i] = am + 1 + i;
                }
            }
            n--;
            if (isBreak) {
                continue;
            }
            int sum = 0;
            for (int i = 0; i < sequence.length; i++) {
                sum += sequence[i];
                String str = i == sequence.length - 1 ? "\n" : ",";
            }
            if (N == sum) {
                result++;
            }
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(consecutiveNumbersSum(1));//1
        System.out.println(consecutiveNumbersSum(3));//2
        System.out.println(consecutiveNumbersSum(5));//2
        System.out.println(consecutiveNumbersSum(15));//4
        System.out.println(consecutiveNumbersSum((int) Math.pow(10, 9)));
    }
}
