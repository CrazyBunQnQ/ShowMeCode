package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * 重新排列数组
 * <p>
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * <p>
 * 输出：[2,3,5,4,1,7]
 * <p>
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * <p>
 * 输出：[1,4,2,3,3,2,4,1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * <p>
 * 输出：[1,2,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * <p>
 * nums.length == 2n
 * <p>
 * 1 <= nums[i] <= 10^3
 *
 * @author CrazyBunQnQ
 * @date 2020/6/27.
 */
@Log4j
public class ShuffleTheArray {
    @Test
    public void shuffleTest() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        shuffle(nums, n);
    }

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }
}
