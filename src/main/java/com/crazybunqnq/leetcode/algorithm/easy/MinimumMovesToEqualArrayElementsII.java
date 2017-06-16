package com.crazybunqnq.leetcode.algorithm.easy;

public class MinimumMovesToEqualArrayElementsII {
    /*
     * Given a non-empty integer array, find the minimum number of moves
     * required to make all array elements equal, where a move is incrementing a
     * selected element by 1 or decrementing a selected element by 1.
     *
     * You may assume the array's length is at most 10,000.
     */
    private static int moves = 0;
    private static int ave;

    public static int minMoves2(int[] nums) {
        while (!isAllElementsEqual(nums)) {
            nums = move(nums);
        }
        return moves;
    }

    private static int[] move(int[] nums) {
        int[] num = nums;
        int max = 0;
        int min = 0;
        int sum = num[0];
        for (int i = 1; i < num.length; i++) {
            max = num[i] > num[max] ? i : max;
            min = num[i] < num[min] ? i : min;
            sum += num[i];
        }
        ave = sum / nums.length;
        System.out.println("average number: " + ave);
        if (num[max] > ave) {
            int m = num[max] - ave == 1 ? 1 : (num[max] - ave) / 2;
            num[max] = num[max] - m;
            moves = moves + m;
        }
        if (num[min] < ave) {
            int m = ave - num[min] == 1 ? 1 : (ave - num[min]) / 2;
            num[min] = num[min] + m;
            moves = moves + m;
        }
        return num;
    }

    private static boolean isAllElementsEqual(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[0]) {
                return false;
            }
        }
        return true;
    }

    public static int[] init() {
        int[] nums = {203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143};
        return nums;
    }
}
