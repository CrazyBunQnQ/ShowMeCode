package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找和替换模式
 * 题目难度 Medium
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 *
 * @version 2018/8/19.
 * @Score 5
 * @auther CrazyBunQnQ
 */
public class FindAndReplacePattern {
    private List<Integer> getMode(String str) {
        Integer tmp = 1;
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer t = map.put(c, tmp);
            if (t == null) {
                result.add(tmp);
                tmp++;
            } else {
                result.add(t);
            }
        }
        return result;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        List<Integer> mode = getMode(pattern);
        for (String word : words) {
            if (mode.equals(getMode(word)))
                ans.add(word);
        }
        return ans;
    }

    @Test
    public void Test() {
        String[][] arr = {{"abc", "deq", "mee", "aqq", "dkd", "ccc"}};
        String[] patterns = {"abb"};

        for (int i = 0; i < arr.length; i++) {
            List<String> result = findAndReplacePattern(arr[i], patterns[i]);
            for (String str : result) {
                System.out.println(str);
            }
        }
    }
}
