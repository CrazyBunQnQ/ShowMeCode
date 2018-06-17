package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 *
 * @version 2018/6/17.
 * @Score 2
 * @auther CrazyBunQnQ
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0, j = A.length - 1, max = 0, index = 0;
        for (; i <= j; i++, j--) {
            if (A[i] > max || A[j] > max) {
                index = A[i] > A[j] ? i : j;
                max = A[i] > A[j] ? A[i] : A[j];
                System.out.println("max:" + max + " i:" + i);
            }
        }
        return index;
    }

    @Test
    public void test() {
        int[][] As = {
                {0, 1, 0},
                {0, 2, 1, 0}};
        for (int[] A : As) {
            System.out.println(peakIndexInMountainArray(A));
        }
    }
}
