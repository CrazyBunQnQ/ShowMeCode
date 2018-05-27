package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 * <p>
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 * <p>
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 * <p>
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 * <p>
 * Example 1:
 * <p>
 * Input: "123456579"
 * Output: [123,456,579]
 * Example 2:
 * <p>
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * Example 3:
 * <p>
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * Example 4:
 * <p>
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 * Example 5:
 * <p>
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * S contains only digits.
 *
 * @version 2018/5/27.
 * @Score 6
 * @auther CrazyBunQnQ
 */
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        findFibonacci(S, result, 0);
        return result;
    }

    /**
     * Find Fibonacci numbers in a string
     *
     * @param sequence Target string
     * @param result Fibonacci numbers in strings are stored in this array
     * @param index starting point
     * @return
     */
    public boolean findFibonacci(String sequence, List<Integer> result, int index) {
        if (index == sequence.length() && result.size() >= 3) {
            return true;
        }
        for (int i = index; i < sequence.length(); i++) {
            // Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
            if (sequence.charAt(index) == '0' && i > index) {
                break;
            }
            long num = Long.parseLong(sequence.substring(index, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();
            // early termination
            if (size >= 2 && num > result.get(size - 1) + result.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (findFibonacci(sequence, result, i + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(splitIntoFibonacci("1101111"));
    }
}
