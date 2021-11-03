package com.crazybunqnq.leetcode.algorithm.medium;

/**
 * 718. 最长重复子数组
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * A: [1,2,3,2,1]
 * <p>
 * B: [3,2,1,4,7]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * <p>
 * 长度最长的公共子数组是 [3, 2, 1]。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * <p>
 * 0 <= A[i], B[i] < 100
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 *
 * @author CrazyBunQnQ
 * @date 2020/7/1.
 */
public class MaximumLengthOfRepeatedSubarray {
    /**
     * TODO 执行用时：67 ms, 在所有 Java 提交中击败了 35.66% 的用户
     * <p>
     * 内存消耗：48.8 MB, 在所有 Java 提交中击败了 100.00% 的用户
     */
    public int findLength(int[] A, int[] B) {
        int result = 0;
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
