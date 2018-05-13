package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * @version 2018/5/13.
 * @Score 3
 * @auther CrazyBunQnQ
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for (int x = 0; x < A.length; x++) {
            int i = 0;
            int j = A[x].length - 1;
            while (j >= i) {
                if (i == j) {
                    result[x][j] = 1 - A[x][i];
                    break;
                }
                result[x][j] = 1 - A[x][i];
                result[x][i] = 1 - A[x][j];
                j--;
                i++;
            }
        }

        return result;
    }

    public void loop(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        int[][] A = {{1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}};

//              {{1, 1, 0, 0},
//              {0, 1, 1, 0},
//              {0, 0, 0, 1},
//              {1, 0, 1, 0}};

        int[][] B = {{1, 1, 0},//100
                {1, 0, 1},//010
                {0, 0, 0}};//111

        loop(B);
        System.out.println();
        loop(flipAndInvertImage(B));

    }
}
