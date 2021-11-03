package com.crazybunqnq.leetcode.algorithm.medium;

/**
 * 面试题 16.01. 交换数字
 * <p>
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * <p>
 * 输出: [2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * numbers.length == 2
 * <p>
 * 链接：https://leetcode-cn.com/problems/swap-numbers-lcci
 *
 * @author CrazyBunQnQ
 * @date 2020/6/28.
 */
public class SwapNumbersLcci {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[1] ^ numbers[0];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
