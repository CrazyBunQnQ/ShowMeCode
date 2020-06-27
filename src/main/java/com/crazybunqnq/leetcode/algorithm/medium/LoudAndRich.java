package com.crazybunqnq.leetcode.algorithm.medium;

/**
 * In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, and different levels of quietness.
 * <p>
 * For convenience, we'll call the person with label x, simply "person x".
 * <p>
 * We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  Note that richer may only be a subset of valid observations.
 * <p>
 * Also, we'll say quiet[x] = q if person x has quietness q.
 * <p>
 * Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]), among all people who definitely have equal to or more money than person x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * Output: [5,5,2,5,4,5,6,7]
 * Explanation:
 * answer[0] = 5.
 * Person 5 has more money than 3, which has more money than 1, which has more money than 0.
 * The only person who is quieter (has lower quiet[x]) is person 7, but
 * it isn't clear if they have more money than person 0.
 * <p>
 * answer[7] = 7.
 * There isn't anyone who definitely has more money than person 7, so the person who definitely has
 * equal to or more money than person 7 is just person 7.
 * <p>
 * The other answers can be filled out with similar reasoning.
 * Note:
 * <p>
 * 1 <= quiet.length = N <= 500
 * 0 <= quiet[i] < N, all quiet[i] are different.
 * 0 <= richer.length <= N * (N-1) / 2
 * 0 <= richer[i][j] < N
 * richer[i][0] != richer[i][1]
 * richer[i]'s are all different.
 * The observations in richer are all logically consistent.
 *
 * @version 2018/6/10.
 * @Score 5
 * @auther CrazyBunQnQ
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        return null;
    }
}
