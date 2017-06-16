package com.crazybunqnq.leetcode.algorithm.easy;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 * @author Administrator
 */
public class SingleNumber {
    public int singleNumber_1ms(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
