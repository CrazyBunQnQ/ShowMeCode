package com.crazybunqnq.leetcode.algorithm.easy;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * Created by CrazyBun on 2016/7/7.
 */
public class MoveZeros {
    /**
     * by myself! defeat 24%
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int numOfZeros = 0;
        int length = nums.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (i + numOfZeros == length) {
                for (int j = 0; j < numOfZeros; j++) {
                    nums[i + j] = 0;
                }
                return;
            }
            while (nums[i + numOfZeros] == 0) {
                if (i + numOfZeros >= length - 1) {
                    break;
                }
                numOfZeros = numOfZeros + 1;
            }
            nums[i] = nums[i + numOfZeros];
        }
    }

    /**
     * defeat 88%
     *
     * @param nums
     */
    public static void moveZeroes0ms(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
