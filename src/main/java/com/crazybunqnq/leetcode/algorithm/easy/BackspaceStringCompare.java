package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * @version 2018/6/3.
 * @Score 3
 * @auther CrazyBunQnQ
 */
public class BackspaceStringCompare {
    public String helper(String s) {
        String reg = "\\w#";
        String tmp = s;
        while (s.lastIndexOf("#") >= 0) {
            tmp = s;
            s = s.replaceAll(reg, "");
            if (tmp.length() == s.length()) {
                break;
            }
        }
        return s.replace("#", "");
    }

    public boolean backspaceCompare(String S, String T) {
        String reg = "\\w#";
        if (helper(S).equals(helper(T)))
            return true;
        return false;
    }

    @Test
    public void test() {
        System.out.println(backspaceCompare("#####a##b", "#####b##a#b"));
    }
}
