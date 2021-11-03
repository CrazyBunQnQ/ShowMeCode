package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;

/**
 * 一维数组的动态和
 * <p>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：[1,3,6,10]
 * <p>
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * <p>
 * 输出：[1,2,3,4,5]
 * <p>
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,2,10,1]
 * <p>
 * 输出：[3,4,6,16,17]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * <p>
 * -10^6 <= nums[i] <= 10^6
 *
 * @author CrazyBunQnQ
 * @date 2020/6/27.
 */
@Log4j
public class RunningSumOfOneDimensionalArray {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }
}
