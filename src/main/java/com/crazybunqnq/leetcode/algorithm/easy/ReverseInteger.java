package com.crazybunqnq.leetcode.algorithm.easy;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * <p>
 * Example2: x = -123, return -321
 * <p>
 * Note:
 * <p>
 * The input is assumed to be a 32-bit signed integer. Your function should
 * return 0 when the reversed integer overflows.
 *
 * @author Administrator
 */
public class ReverseInteger {
    /**
     * -2147483648 ~ 2147483647
     */
    public static void test() {
        // System.out.println(reverse(2147483646));
        System.out.println(reverse_43ms(-2147483641));
    }

    private static int reverse_43ms(int x) {
        boolean minus = x < 0;
        StringBuilder str = new StringBuilder(minus ? String.valueOf(x).substring(1) : String.valueOf(x));
        String s = minus ? new StringBuilder("-").append(str.reverse()).toString() : str.reverse().toString();
        int i;
        try {
            i = Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    private static int reverse_42ms(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
