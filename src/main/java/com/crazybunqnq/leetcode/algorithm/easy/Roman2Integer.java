package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999(I to MMMCMXCIX).
 *
 * @version 2017/7/18.
 * @auther CrazyBunQnQ
 */
@Log4j
public class Roman2Integer {

    @Test
    public void test() {//M:77,C:67,X:88,V:86,I:73
        log.info(romanToInt103ms("MMMCMXCIX"));
        log.info(romanToInt103ms("MDCCCLXXXIV"));
        log.info(romanToInt103ms("MCDLXXVI"));
    }


    public int romanToInt103ms(String s) {
        int result = 0;
        char last = 0;
        //从末位开始转换
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int tmp = getNumber(c);
            //如果前一个（低一位）罗马数字大于当前的罗马数字则进行减法运算
            if (i != s.length() - 1 && last != c && getNumber(last) > tmp) {
                result -= tmp;
            } else {//其他情况进行加法运算
                result += tmp;
            }
            //记录上一个数字
            last = c;
        }
        return result;
    }

    /**
     * 将单个罗马字母转换为数字
     *
     * @param c
     *
     * @return
     */
    private int getNumber(char c) {
        int tmp = 0;
        switch (c) {
            case 'I':
                tmp = 1;
                break;
            case 'V':
                tmp = 5;
                break;
            case 'X':
                tmp = 10;
                break;
            case 'L':
                tmp = 50;
                break;
            case 'C':
                tmp = 100;
                break;
            case 'D':
                tmp = 500;
                break;
            case 'M':
                tmp = 1000;
                break;
            default:
        }
        return tmp;
    }
}
