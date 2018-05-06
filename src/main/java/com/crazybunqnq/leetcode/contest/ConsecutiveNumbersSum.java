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
    /**
     * Sn = (a1 + an) * n / 2
     * d = (an - a1) / (n - 1)
     *
     * @param N
     *
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int result = 1;
        Integer n = N / 2 + 1;
        int sum;

        while (n > 1 && N != 2) {
            if (N * 2 % n != 0) {
                n--;
                continue;
            }
            int am = N / n;
            if (N % n == 0) {
                //N/n 是中间数
                int m = (n - 1) / 2;
                int a1 = am - m;
                if (a1 <= 0) {
                    n--;
                    continue;
                }
                int an = am + m;
                sum = (a1 + an) * n / 2;
            } else {
                int m1 = n / 2 - 1;
                int m2 = n / 2;
                int a1 = am - m1;
                if (a1 <= 0) {
                    n--;
                    continue;
                }
                int an = am + 1 + m1;
                sum = (a1 + an) * n / 2;
            }
            n--;
            if (N == sum) {
                result++;
            }
        }

        return result;
    }

    @Test
    public void test() {
//        System.out.println(consecutiveNumbersSum(1));//1
        System.out.println(consecutiveNumbersSum(2));//1
//        System.out.println(consecutiveNumbersSum(3));//2
        System.out.println(consecutiveNumbersSum(4));//1
//        System.out.println(consecutiveNumbersSum(5));//2
        System.out.println(consecutiveNumbersSum(6));//2
//        System.out.println(consecutiveNumbersSum(15));//4
//        System.out.println(consecutiveNumbersSum((int) Math.pow(10, 9)));
    }
}
