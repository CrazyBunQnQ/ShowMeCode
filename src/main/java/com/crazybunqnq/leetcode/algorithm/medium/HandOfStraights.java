package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Alice has a hand of cards, given as an array of integers.
 * <p>
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * <p>
 * Return true if and only if she can.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 * @version 2018/6/3.
 * @Score 5
 * @auther CrazyBunQnQ
 */
public class HandOfStraights {
    /**
     * Intuition:
     * <p>
     * Count number of different cards to a map c.
     * <p>
     * Loop from the smallest card number.
     * <p>
     * Everytime we meet a new card i, we cut off i - i + W - 1 from the counter.
     * <p>
     * Time Complexity:
     * <p>
     * O(MlogM + MW), where M is the number of different cards.
     *
     * @param hand
     * @param W
     *
     * @return
     */
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) {
            c.put(i, c.getOrDefault(i, 0) + 1);
        }
        for (int it : c.keySet())
            if (c.get(it) > 0) {
                for (int i = W - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) {
                        return false;
                    }
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
            }
        return true;
    }

    @Test
    public void test() {
        int[][] hands = {{1, 1, 2, 2, 3, 3}, {1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3, 6, 2, 3, 4, 7, 8}};
        int[] ws = {2, 1, 4, 3};
        for (int i = 0; i < ws.length; i++) {
            int[] hand = hands[i];
            int w = ws[i];
            System.out.println(isNStraightHand(hand, w));
        }
    }
}
