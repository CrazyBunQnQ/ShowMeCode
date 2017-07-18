package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * Determine whether an integer is a palindrome. Do this without extra space[extra space usually means O(n) extra space.].
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
        log.info(isPalindrome250ms(-2147447412));
        log.info(isPalindrome192ms(2147447412));
    }


    public boolean isPalindrome250ms(int x) {
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

    public boolean isPalindrome192ms(int x) {
        //排除小于零或以零结尾的数字
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        /**
         * 反转数：保存从个位开始，反换后的数字
         */
        int rev = 0;
        //只判断数字长度的一半：原数小于等于反转数则表示转换结束
        while (x > rev) {
            //原数去除最后一位，添加到反转数的末位
            rev = rev * 10 + x % 10;
            x = x / 10;//
        }
        //判断反转数和原数前一半是否相同，例如 1221 判断 12 == 12
        //或原数前一半与去除中间数后的反转数是否相同，例如 12321 判断 12 == 12
        return (x == rev || x == rev / 10);
    }
}
