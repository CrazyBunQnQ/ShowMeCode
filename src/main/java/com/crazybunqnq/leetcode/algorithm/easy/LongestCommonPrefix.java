package com.crazybunqnq.leetcode.algorithm.easy;

import org.junit.Test;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * <p>
 * 输出: "fl"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * <p>
 * 输出: ""
 * <p>
 * 解释: 输入不存在公共前缀。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author CrazyBunQnQ
 * @date 2020/6/28.
 */
public class LongestCommonPrefix {
    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
//        longestCommonPrefix(strs);
//        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * TODO 执行结果：超出内存限制
     */
    public String longestCommonPrefixX(String[] strs) {
        StringBuilder sb = new StringBuilder();
        boolean f = true;
        char c = '0';
        int j = 0;
        while (f) {
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    c = strs[i].charAt(j);
                } else {
                    if (strs[i].length() <= j || strs[i].charAt(j) != c) {
                        f = false;
                        break;
                    }
                }
            }
            if (f) {
                j++;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
