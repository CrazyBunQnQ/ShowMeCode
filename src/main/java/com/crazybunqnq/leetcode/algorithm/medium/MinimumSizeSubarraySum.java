package com.crazybunqnq.leetcode.algorithm.medium;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * <p>
 * 进阶:
 * <p>
 * TODO 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * @author CrazyBunQnQ
 * @date 2020/6/28.
 */
public class MinimumSizeSubarraySum {
    /**
     * 执行用时：192 ms, 在所有 Java 提交中击败了 8.60% 的用户
     * <p>
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了 6.67% 的用户
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmpL = 1;
            int tmpS = nums[i - 1];
            while (i + tmpL - 1 < nums.length && tmpS < s) {
                tmpS += nums[i + tmpL - 1];
                tmpL++;
            }
            if (tmpS >= s && (tmpL < result || result == 0)) {
                result = tmpL;
            }
        }
        return result;
    }
}
