package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 *
 * @version 2018/6/24.
 * @Score 5
 * @auther CrazyBunQnQ
 */
public class ScoreOfParentheses {
    String rexA = "\\(\\)";
    String rex2A = "\\('(\\d+)'\\)";
    String rexAA = "'(\\d+)''(\\d+)'";
    Pattern pat2A = Pattern.compile(rex2A);
    Pattern patAA = Pattern.compile(rexAA);

    public String helper(String S) {
        String result = S;
        Matcher m2A = pat2A.matcher(result);
        Matcher mAA = patAA.matcher(result);
        if (m2A.find()) {
            String rep = "'" + Integer.valueOf(m2A.group(1)) * 2 + "'";
            result = result.replaceAll(rex2A, rep);
        } else if (mAA.find()) {
            String rep = "'" + (Integer.valueOf(mAA.group(1)) + Integer.valueOf(mAA.group(2))) + "'";
            result = result.replaceAll(rexAA, rep);
        } else {
            return result;
        }
        return helper(result);
    }

    public int scoreOfParentheses(String S) {
        String str = S.replaceAll(rexA, "'1'");
        str = helper(str);
        return Integer.valueOf(str.replace("'", ""));
    }

    /**
     * 非递归，使用堆栈，O(n)复杂度
     *
     * @param S
     *
     * @return
     */
    public int useStack(String S) {
        int[] sum = new int[S.length() * 2];
        int[] open = new int[S.length() * 2];
        int top1 = 0, top2 = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                open[++top2] = i;
                sum[++top1] = 0;
            } else {
                if (open[top2] == i - 1) {
                    top2--;
                    sum[--top1]++;
                } else {
                    top2--;
                    sum[top1 - 1] += 2 * sum[top1];
                    top1--;
                }
            }
        }
        return sum[0];
    }

    @Test
    public void test() {
        String[] ss = {"()()()(())", "()", "(())", "()()", "(()(()))"};
        for (String S : ss) {
            System.out.println(scoreOfParentheses(S));
        }
    }
}
