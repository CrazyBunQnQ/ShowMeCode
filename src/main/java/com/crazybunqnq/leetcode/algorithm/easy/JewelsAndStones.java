package com.crazybunqnq.leetcode.algorithm.easy;

/**
 * 771. 宝石与石头
 * <p>
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * <p>
 * 输出: 3
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * <p>
 * 输出: 0
 * <p>
 * <p>
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 * <p>
 *  J 中的字符不重复。
 *
 * @author CrazyBunQnQ
 * @date 2020/6/28.
 */
public class JewelsAndStones {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了 99.52% 的用户
     * <p>
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了 9.09% 的用户
     */
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for (char s : S.toCharArray()) {
            if (J.indexOf(s) >= 0) {
                result++;
            }
        }
        return result;
    }
}
