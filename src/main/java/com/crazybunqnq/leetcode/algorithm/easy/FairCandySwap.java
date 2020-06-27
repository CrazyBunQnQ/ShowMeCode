package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * 公平的糖果交换
 * <p>
 * 题目难度 Easy
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 *
 * @version 2018/8/19.
 * @Score 3
 * @auther CrazyBunQnQ
 */
public class FairCandySwap {
    private int sumArry(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    private int isContain(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i)
                return j;
        }
        return -1;
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = sumArry(A);
        int sumB = sumArry(B);
        int diff = (sumA + sumB) / 2 - sumA;
        for (int a : A) {
            int b = diff + a;
            if (isContain(B, b) != -1) {
                return new int[]{a, b};
            }
        }
        return new int[2];
    }

    @Test
    public void Test() {
        int[][] As = {{1, 1}, {1, 2}, {2}, {1, 2, 5}};
        int[][] Bs = {{2, 2}, {2, 3}, {1, 3}, {2, 4}};

        for (int i = 0; i < As.length; i++) {
            int[] ans = fairCandySwap(As[i], Bs[i]);
            System.out.printf(ans.toString());
        }
    }
}
