package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;

/**
 * 数组异或操作
 * <p>
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, start = 0
 * <p>
 * 输出：8
 * <p>
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * <p>
 * "^" 为按位异或 XOR 运算符。
 * <p>
 * <b><font color="#FF6666">Java 没有乘幂运算符,必须使用 Math.pow(x,n) 方法, 表示 x 的 n 次幂</font></b>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4, start = 3
 * <p>
 * 输出：8
 * <p>
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 1, start = 7
 * <p>
 * 输出：7
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 10, start = 5
 * <p>
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 *  
 * 0 <= start <= 1000
 *  
 * n == nums.length
 *
 * @author CrazyBunQnQ
 * @date 2020/6/27.
 */
@Log4j
public class XorOperationInAnArray {
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            int e = start + 2 * i;
            result = result ^ e;
        }
        return result;
    }
}
