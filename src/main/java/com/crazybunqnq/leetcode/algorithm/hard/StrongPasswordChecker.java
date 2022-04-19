package com.crazybunqnq.leetcode.algorithm.hard;

/**
 * [420]强密码检验器
 * <p>
 * 如果一个密码满足下述所有条件，则认为这个密码是强密码：
 * <p>
 * 由至少 6 个，至多 20 个字符组成。
 * <p>
 * 至少包含 一个小写 字母，一个大写 字母，和 一个数字 。
 * <p>
 * 同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 如果满足其他条件也可以算是强密码)。
 * <p>
 * 给你一个字符串 password ，返回将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 。
 * <p>
 * 在一步修改操作中，你可以：
 * <p>
 * 插入一个字符到 password ，从 password 中删除一个字符，或用另一个字符来替换 password 中的某个字符。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：password = "a"
 * <p>
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：password = "aA1"
 * <p>
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入：password = "1337C0d3"
 * <p>
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= password.length <= 50
 * <p>
 * password 由字母、数字、点 '.' 或者感叹号 '!'
 * <p>
 * Related Topics 贪心 字符串 堆（优先队列） 👍 74 👎 0
 *
 * @author baojunjie
 * @date 2021/12/3
 */
public class StrongPasswordChecker {
}
