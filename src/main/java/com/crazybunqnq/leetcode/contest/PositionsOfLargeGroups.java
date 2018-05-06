package com.crazybunqnq.leetcode.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * Example 1:
 * <p>
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * <p>
 * Note:  1 <= S.length <= 1000
 *
 * @version 2018/5/6.
 * @Score 3
 * @auther CrazyBunQnQ
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> dic = new ArrayList<List<Integer>>();
        Integer start = 0;
        Integer tmp = 0;
        for (int i = 1; i < S.length(); i++) {
            if (tmp == 0) {
                start = i - 1;
            }
            char s1 = S.charAt(i - 1);
            char s2 = S.charAt(i);
            if (S.charAt(i) == S.charAt(i - 1)) {
                tmp++;
                if (tmp >= 2 && i == S.length() - 1) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(start);
                    sub.add(start + tmp);
                    dic.add(sub);
                }
            } else if (tmp >= 2) {
                List<Integer> sub = new ArrayList<>();
                sub.add(start);
                sub.add(start + tmp);
                dic.add(sub);
                tmp = 0;
            } else {
                tmp = 0;
            }
        }
        return dic;
    }

    @Test
    public void test() {
        System.out.println(largeGroupPositions("a"));
        String s1000 = "abbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzyaabbxxxxzzy";
        System.out.println(s1000.length());
        System.out.println(largeGroupPositions(s1000));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcddd"));
    }
}
