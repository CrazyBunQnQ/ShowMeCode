package com.crazybunqnq.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CanIWin {
    /*
	 * In the "100 game," two players take turns adding, to a running total, any
	 * integer from 1..10. The player who first causes the running total to
	 * reach or exceed 100 wins.
	 * 
	 * What if we change the game so that players cannot re-use integers?
	 * 
	 * For example, two players might take turns drawing from a common pool of
	 * numbers of 1..15 without replacement until they reach a total >= 100.
	 * 
	 * Given an integer maxChoosableInteger and another integer desiredTotal,
	 * determine if the first player to move can force a win, assuming both
	 * players play optimally.
	 * 
	 * You can always assume that maxChoosableInteger will not be larger than 20
	 * and desiredTotal will not be larger than 300.
	 */

	/*
	 * Example
	 * 
	 * Input: maxChoosableInteger = 10 desiredTotal = 11
	 * 
	 * Output: false
	 * 
	 * Explanation: No matter which integer the first player choose, the first
	 * player will lose. The first player can choose an integer from 1 up to 10.
	 * If the first player choose 1, the second player can only choose integers
	 * from 2 up to 10. The second player will win by choosing 10 and get a
	 * total = 11, which is >= desiredTotal. Same with other integers chosen by
	 * the first player, the second player will always win.
	 */

    private static List<Integer> pool;
    private static int raceTo;

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		/*
		 * If (finalSum > combined sum of all numbers). This is an impossible
		 * problem to solve
		 */
        if (desiredTotal > ((maxChoosableInteger * maxChoosableInteger + maxChoosableInteger) / 2)) {
            throw new IllegalArgumentException("Expected sum cannot be achieved!");
        }

        raceTo = desiredTotal;
        pool = new ArrayList<Integer>();
        for (int i = 0; i < maxChoosableInteger; i++) {
            pool.add(i + 1);
        }

		/* Autoplay the game with optimal mooves */
        int turns = 0;
        while (raceTo > 0) {
            turns++;
            System.out.println("Player" + ((turns % 2 == 0) ? "2" : "1") + " ==> " + pickANumber() + "   == Remaining [" + raceTo + "]");
        }
        return (turns % 2 == 1);
    }

    /*
     * Pick an Optimal number, so to win or prevent he opponent from winning
     */
    private static int pickANumber() {
        int leastMax = -1;
        int len = pool.size();
        for (int i = len - 1; i >= 0; i--) {
            int tmp = pool.get(i);
            if (tmp >= raceTo) {
				/* Winning Pick */
                pool.remove(i);
                raceTo -= tmp;
                return tmp;
            } else {
                if (leastMax > 0) {
					/*
					 * Picking the highest number available in the pool might
					 * let the next player win. So picking a number < leastMax,
					 * if available - to gaurentee otherwise.
					 */
                    if (tmp < leastMax) {
                        pool.remove(i);
                        raceTo -= tmp;
                        return tmp;
                    } else {
                        continue;
                    }
                }

                if (i - 1 >= 0) {
					/*
					 * We know, the highest number available in the pool is <
					 * raceTo (target sum) Check in the pool if the sum of the
					 * highest number + nextHighest number >= raceTo (target
					 * sum) [True] => Skip both the numbers and look for a
					 * number < the LeastMax so the opposite player does not
					 * win. [False] => The highest number in the pool is the
					 * best pick
					 */
                    if (tmp + pool.get(i - 1) < raceTo) {
                        pool.remove(i);
                        raceTo -= tmp;
                        return tmp;
                    } else {
                        leastMax = raceTo - tmp;
                        i--;
                        continue;
                    }
                } else {
                    pool.remove(i);
                    raceTo -= tmp;
                    return tmp;
                }
            }
        }

		/*
		 * The raceTo sum cannot be achieved in this turn. There is no number
		 * available in the pool that can prevent a Win in the next turn. So we
		 * return the highest number availble in the pool.
		 */
        int tmp = pool.get(pool.size() - 1);
        pool.remove(pool.size() - 1);
        raceTo -= tmp;
        return tmp;
    }
}
