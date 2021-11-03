package com.crazybunqnq.leetcode.algorithm.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * <p>
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "()"
 * <p>
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()[]{}"
 * <p>
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "(]"
 * <p>
 * 输出：false
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "([)]"
 * <p>
 * 输出：false
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：s = "{[]}"
 * <p>
 * 输出：true
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * <p>
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * Related Topics 栈 字符串 👍 2740 👎 0
 *
 * @author baojunjie
 * @date 2021/11/3
 */
public class EffectiveBrackets {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
