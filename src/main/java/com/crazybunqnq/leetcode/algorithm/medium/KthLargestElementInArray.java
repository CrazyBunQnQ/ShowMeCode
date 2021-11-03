package com.crazybunqnq.leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @author CrazyBunQnQ
 * @date 2020/6/29.
 */
public class KthLargestElementInArray {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了 92.63% 的用户
     * <p>
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了 6.12% 的用户
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
