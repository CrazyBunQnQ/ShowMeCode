package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * <b>Some hints:</b>
 * <p>
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 *
 * @version 2017/7/17.
 * @auther CrazyBunQnQ
 */
@Log4j
public class PalindromeNumber {

    @Test
    public void isPalindrome() {
        log.info(isPalindrome(-2147447412));
    }


    public boolean isPalindrome(int x) {
        //如果数字小于 0 则直接返回 false
        if (x < 0) {
            return false;
        }
        int modNum = 0;
        int oldNum = x;
        int newNum = 0;

        while (x / 10 != 0) {//当 oldNum 为一位数时停止循环
            modNum = x % 10;
            x /= 10;
            newNum = newNum * 10 + modNum;
        }
        newNum = newNum * 10 + x;//获得反转后的整数

        return newNum == oldNum;
    }
}
