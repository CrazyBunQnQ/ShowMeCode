package com.crazybunqnq.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 给定一个整数数组和一个目标值，返回两个数的数组，这两个数的和为目标值。
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 你可以假设每个输入恰好只有一个解决方案，并且你可以不使用相同的元素两次。
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author Administrator
 */
public class TwoSum {
    public static int[] twoSum_3ms(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]) - 1;
                return result;
            }
            map.put(nums[i], i + 1);
        }
        return result;
    }

    /**
     * 使用了两次相同元素
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public static int[] twoSum_1ms(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[1] = i;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    break;
                }
                if (nums[i] + nums[j] == target) {
                    result[0] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
