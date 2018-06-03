package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        Integer[] arr = new Integer[hand.length];
        for (int i = 0; i < hand.length; i++) {
            arr[i] = hand[i];
        }
        Arrays.sort(arr);
        if (W == 1) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    return false;
                }
            }
        }
        List tmp = Arrays.asList(arr);
        ArrayList<Integer> list = new ArrayList<Integer>(tmp);
        for (int i = 0; i < list.size(); i = 0) {
            for (int j = 0; j < W; j++) {
                Integer a = list.get(i);
                Integer b = list.get(i + 1);
                if (b > a + 1) {
                    return false;
                }
                if (b == a + 1) {
                    if (j == W - 2) {
                        list.remove(i + 1);
                        j++;
                    }
                    list.remove(i);
                }
                if (b == a) {
                    i++;
                    j--;
                }
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
