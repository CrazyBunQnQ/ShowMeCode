package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 *
 * @version 2018/6/24.
 * @Score 4
 * @auther CrazyBunQnQ
 */
public class BuddyStrings {
    /**
     * 判断包含重复字母
     *
     * @param str
     *
     * @return
     */
    public boolean hasRepeatedLetters(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] elements = str.toCharArray();
        for (char e : elements) {
            if (str.indexOf(e) != str.lastIndexOf(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2)
            return false;
        if (A.equals(B) && !hasRepeatedLetters(A))
            return false;
        if (A.length() == 2 && A.charAt(0) == B.charAt(1) && A.charAt(1) == B.charAt(0))
            return true;
        int n = 0, sumA = 0, sumB = 0;
        for (int i = 0; i < A.length(); i++) {
            sumA += A.charAt(i);
            sumB += B.charAt(i);
            if (A.charAt(i) != B.charAt(i)) {
                n++;
            }
        }
        if (sumA != sumB)
            return false;
        if ((A.length() == 2 && n != 2) || (A.length() == 3 && n > 1) || A.length() > 3 && n > 2)
            return false;
        return true;
    }

    @Test
    public void test() {
        String[] As = {"ab", "ab", "aa", "aaaaaaabc", "", "abcd", "ab"};
        String[] Bs = {"ba", "ab", "aa", "aaaaaaacb", "aa", "abcd", "ca"};
        for (int i = 0; i < As.length; i++) {
            System.out.println(buddyStrings(As[i], Bs[i]));
        }
    }
}
