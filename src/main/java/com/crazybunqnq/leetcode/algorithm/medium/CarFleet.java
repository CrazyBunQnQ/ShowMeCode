package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

/**
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 * <p>
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 * <p>
 * The distance between these two cars is ignored - they are assumed to have the same position.
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * <p>
 * <p>
 * How many car fleets will arrive at the destination?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 * <p>
 * Note:
 * <p>
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * All initial positions are different.
 * <p>
 * 返回车队的数量而不是第一个车队有多少辆车
 *
 * @version 2018/6/17.
 * @Score 6
 * @auther CrazyBunQnQ
 */
public class CarFleet {

    public static void quickSort(int[] position, int[] speed) {
        qsort(position, speed, 0, position.length - 1);
    }

    private static void qsort(int[] position, int[] speed, int low, int high) {
        if (low < high) {
            int pivot = partition(position, speed, low, high);        //将数组分为两部分
            qsort(position, speed, low, pivot - 1);                   //递归排序左子数组
            qsort(position, speed, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] position, int[] speed, int low, int high) {
        int pivot = position[low];     //枢轴记录
        int speedPivot = speed[low];
        while (low < high) {
            while (low < high && position[high] >= pivot) --high;
            position[low] = position[high];             //交换比枢轴小的记录到左端
            speed[low] = speed[high];
            while (low < high && position[low] <= pivot) ++low;
            position[high] = position[low];           //交换比枢轴小的记录到右端
            speed[high] = speed[low];
        }
        //扫描完成，枢轴到位
        position[low] = pivot;
        speed[low] = speedPivot;
        //返回的是枢轴的位置
        return low;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }
        //先排序
        quickSort(position, speed);
        int count = 0;

        //第一个车队所用时间
//        float time = target;
        float time = 0;
        for (int i = speed.length - 1; i >= 0; i--) {
            float distance = target - position[i];
            float time2 = distance / speed[i];
            System.out.println("行驶距离: " + distance + " 行驶速度: " + speed[i] + " 所需时间: " + time2);
            if (time2 > time) {
                count++;
                time = time2;
                System.out.println("第 " + i + " 个车队所用时间 " + time);
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] targets = {12, 10};
        int[][] positions = {
                {10, 8, 0, 5, 3},
                {0, 4, 2}
        };
        int[][] speeds = {
                {2, 4, 1, 1, 3},
                {2, 1, 3}
        };


        for (int i = 0; i < targets.length; i++) {
            int target = targets[i];
            int[] position = positions[i];
            int[] speed = speeds[i];
            quickSort(position, speed);
            for (int j = position.length - 1; j >= 0; j--) {
                System.out.println("行驶距离: " + (target - position[j]) + " 初始位置: " + position[j] + " 行驶速度: " + speed[j]);
            }
            System.out.println(carFleet(target, position, speed));
        }
    }
}
