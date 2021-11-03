package com.crazybunqnq.leetcode.algorithm.easy;

/**
 * 1281. 整数的各位积和之差
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * 各位数之积 = 2 * 3 * 4 = 24
 * <p>
 * 各位数之和 = 2 + 3 + 4 = 9
 * <p>
 * 结果 = 24 - 9 = 15
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * <p>
 * 输出：21
 * <p>
 * 解释：
 * <p>
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * <p>
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * <p>
 * 结果 = 32 - 11 = 21
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 *
 * @author CrazyBunQnQ
 * @date 2020/6/28.
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum0ms(int n) {
        int sub = 1, sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sub *= digit;
            sum += digit;
        }
        return sub - sum;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了 20.15% 的用户
     * <p>
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了 6.06% 的用户
     */
    public int subtractProductAndSum1ms(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int sub = 1;
        int sum = 0;
        for (char c : s) {
            int i = Character.getNumericValue(c);
            if (sub == 0 || i == 0) {
                sub = 0;
            } else {
                sub *= i;
            }
            sum += i;
        }
        return sub - sum;
    }
}
