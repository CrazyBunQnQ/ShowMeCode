package com.crazybunqnq.leetcode.algorithm.easy;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Created by CrazyBun on 2016/6/30.
 */
public class SumOfTwoIntegers {
    /**
     * 求和 很快
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static int getSum(int a, int b) {
        return a + b;
    }

    /**
     * 求和
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static int getSum2(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}
