package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * <p>
 * Given an N x N grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * <p>
 * while this one is not:
 * 384
 * 519
 * 762
 * <p>
 * In total, there is only one magic square inside the given grid.
 * Note:
 * <p>
 * 1 <= grid.length = grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 * @version 2018/5/27.
 * @Score 3
 * @auther CrazyBunQnQ
 */
public class MagicSquaresInGrid {
    public boolean isMagicSquare(int[][] square) {
        int tmp = square[0][0] + square[1][1] + square[2][2];
        if (tmp != square[2][0] + square[1][1] + square[0][2]) {
            return false;
        }
        for (int r = 0; r < 3; r++) {
            if (square[r][0] == 0 || square[r][1] == 0 || square[r][2] == 0 || square[r][0] > 9 || square[r][1] > 9 || square[r][2] > 9 || tmp != square[r][0] + square[r][1] + square[r][2]) {
                return false;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (square[0][c] == 0 || square[1][c] == 0 || square[2][c] == 0 || square[0][c] > 9 || square[1][c] > 9 || square[2][c] > 9 || tmp != square[0][c] + square[1][c] + square[2][c]) {
                return false;
            }
        }
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int[][] tmp;
        int count = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[i].length; j++) {
                tmp = new int[][]{{grid[i - 2][j - 2], grid[i - 2][j - 1], grid[i - 2][j]},
                        {grid[i - 1][j - 2], grid[i - 1][j - 1], grid[i - 1][j]},
                        {grid[i][j - 2], grid[i][j - 1], grid[i][j]}};
                if (isMagicSquare(tmp)) count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[][][] arr = {
                {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}},
                {
                        {10, 3, 5},
                        {1, 6, 11},
                        {7, 9, 2}}
        };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(numMagicSquaresInside(arr[i]));
        }
    }
}
