package com.crazybunqnq.leetcode.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit. For example: Given num = 38, the process is like:
 * 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Created by CrazyBun on 2016/6/30.
 */
public class AddDigits {
    /**
     * @param num
     *
     * @return
     */
    public static int addDigits(int num) {
        int n = 0;

        while (num != 0) {
            n += (num % 10);
            num /= 10;
        }

        return n > 9 ? addDigits(n) : n;
    }

    /**
     * 时间复杂度为O(1)
     *
     * @param num
     *
     * @return
     */
    public static int addDigitsO1(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }
}
