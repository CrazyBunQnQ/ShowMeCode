package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 * <p>
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 * <p>
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 *
 * @version 2018/6/10.
 * @Score 4
 * @auther CrazyBunQnQ
 */
@Log4j
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int start = 0;
        int end = 0;
        int distance = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                start = end;
                end = i;
                distance = end - start > distance ? end - start : distance;
            }
        }
        return distance % 2 == 0 ? distance / 2 + 1 : (distance + 1) / 2;
    }

    @Test
    public void test() {
        int[][] ints = {
                {1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}
        };
        for (int[] i : ints) {
            System.out.println(maxDistToClosest(i));
        }
    }
}
