package com.crazybunqnq.leetcode.algorithm.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子序列宽度之和
 * <p>
 * 题目难度 Hard
 * 给定一个整数数组 A ，考虑 A 的所有非空子序列。
 * <p>
 * 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。
 * <p>
 * 返回 A 的所有子序列的宽度之和。
 * <p>
 * 由于答案可能非常大，请返回答案模 10^9+7。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[2,1,3]
 * 输出：6
 * 解释：
 * 子序列为 [1]，[2]，[3]，[2,1]，[2,3]，[1,3]，[2,1,3] 。
 * 相应的宽度是 0，0，0，1，1，2，2 。
 * 这些宽度之和是 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 *
 * @version 2018/8/19.
 * @Score 7
 * @auther CrazyBunQnQ
 */
public class SumOfSubsequenceWidths {
    /**
     * 获取整数数组的宽度
     *
     * @param arr
     *
     * @return
     */
    private int getWidth(List<Integer> arr) {
        if (arr.size() <= 1)
            return 0;
        Integer min = arr.get(0);
        Integer max = arr.get(0);
        for (Integer i : arr) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        return max - min;
    }

    /**
     * 获取所有子数组
     *
     * @param arr
     *
     * @return
     */
    private List<List<Integer>> getSubArr(int[] arr) {
        List<List<Integer>> subArrs = new ArrayList<>();
        int nEnd = 1 << arr.length;
        for (int mark = 0; mark < nEnd; mark++) {
            List<Integer> subArr = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (((1 << i) & mark) != 0) {//该位有元素输出
                    subArr.add(arr[i]);
                }
            }
            if (subArr.size() > 0)
                subArrs.add(subArr);
        }
        return subArrs;
    }

    public int sumSubseqWidthsMe(int[] A) {
        int sum = 0;
        List<List<Integer>> subArrs = getSubArr(A);
        for (List<Integer> subArr : subArrs) {
            sum += getWidth(subArr);
        }
        return sum;
    }

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long c = 1;
        long res = 0;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < A.length; ++i, c = (c << 1) % mod)
            res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;
        return (int) ((res + mod) % mod);
    }

    @Test
    public void Test() {
        int[][] arr = {{9, 1, 25, 29, 21, 30, 37, 2, 39, 6, 28, 16, 32, 32, 7, 3, 15, 39, 32, 11},
                {2, 1, 3}};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(sumSubseqWidths(arr[i]));
        }
    }
}
