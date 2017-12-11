package com.crazybunqnq.leetcode.algorithm.medium;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @version 2017/7/18.
 * @auther CrazyBunQnQ
 */
@Log4j
public class Integer2Roman {

    @Test
    public void test() {
        log.info(intToRoman(1894));
        log.info(intToRoman95ms(9));
        log.info(intToRoman95ms(1884));
    }

    /**
     * 将 1~3999 的整数转化成罗马数字
     * @param num 待转化数字
     * @return boolean
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将 1~3999 的数字转换成罗马数字
     * @param num 待转化的数字
     * @return 罗马数字
     */
    public String intToRoman95ms(int num) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("D", 500);
        romanMap.put("C", 100);
        romanMap.put("L", 50);
        romanMap.put("X", 10);
        romanMap.put("V", 5);
        romanMap.put("I", 1);
        StringBuilder sb = new StringBuilder();
        String[] roman = {"M", "D", "C", "L", "X", "V", "I"};

        while (num > 0) {
            for (int i = 0; i < roman.length; i++) {
                String str = roman[i];
                int num1 = romanMap.get(str);
                if (num / num1 > 0) {
                    sb.append(str);
                    num -= num1;
                    i--;
                } else if (i + 1 < roman.length && isCXI(roman[i + 1])) {
                    String str2 = roman[i + 1];
                    int num2 = romanMap.get(str2);
                    if ((num + num2) / num1 > 0) {
                        sb.append(str2 + str);
                        num -= (num1 - num2);
                    }
                } else if (i + 2 < roman.length && isCXI(roman[i + 2])) {
                    String str2 = roman[i + 2];
                    int num2 = romanMap.get(str2);
                    if ((num + num2) / num1 > 0) {
                        sb.append(str2 + str);
                        num -= (num1 - num2);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 判断罗马数字字符是否为 C X I 之一
     *
     * @param s 罗马字符
     *
     * @return boolean
     */
    private boolean isCXI(String s) {
        return "I".equals(s) || "X".equals(s) || "C".equals(s);
    }
}
