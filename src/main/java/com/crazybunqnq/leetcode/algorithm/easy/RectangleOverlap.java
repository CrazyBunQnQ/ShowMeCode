package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 * <p>
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * <p>
 * Given two rectangles, return whether they overlap.
 * <p>
 * Example 1:
 * <p>
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 * <p>
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 *
 * @version 2018/5/20.
 * @Score 3
 * @auther CrazyBunQnQ
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean a = rec1[0] > rec2[0] && rec1[0] < rec2[2];
        boolean b = rec1[2] > rec2[0] && rec1[2] < rec2[2];
        boolean c = rec1[1] > rec2[1] && rec1[1] < rec2[3];
        boolean d = rec1[3] > rec2[1] && rec1[3] < rec2[3];
        System.out.println(a + " " + b + " " + c + " " + d);
        return (a || b) && (c || d);
    }

    @Test
    public void test() {

        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        System.out.println(isRectangleOverlap(rec1, rec2));
        int[] rec3 = {0, 0, 1, 1};
        int[] rec4 = {1, 0, 2, 1};
        System.out.println(isRectangleOverlap(rec3, rec4));
        int[] rec5 = {7, 8, 13, 15};
        int[] rec6 = {10, 8, 12, 20};
        System.out.println(isRectangleOverlap(rec5, rec6));
        int[] rec7 = {0, 0, 1, 1};
        int[] rec8 = {2, 2, 3, 3};
        System.out.println(isRectangleOverlap(rec7, rec8));
    }
}
