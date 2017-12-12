package com.crazybunqnq.leetcode.algorithm.hard;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 * <p>
 * For example,
 * <p>
 * 123 ->  "One Hundred Twenty Three "
 * 12345 ->  "Twelve Thousand Three Hundred Forty Five "
 * 1234567 ->  "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven "
 *
 * @version 2017/12/12.
 * @auther CrazyBunQnQ
 */
@Log4j
public class IntegertoEnglishWords {
    private String[] oneToNine = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    private String[] twentyToNinety = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private String[] elevenToNineteen = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};

    private String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "Zero";
        }
        while (num > 0) {
            if (num >= 1000000000) {
                sb.append(oneToNine[num / 1000000000 - 1]);
                sb.append("Billion ");
                num -= (num / 1000000000 * 1000000000);
            } else if (num >= 1000000) {
                sb.append(oneToThousandStr(num / 1000000));
                sb.append("Million ");
                num -= (num / 1000000 * 1000000);
            } else if (num >= 1000) {
                sb.append(oneToThousandStr(num / 1000));
                sb.append("Thousand ");
                num -= (num / 1000 * 1000);
            } else {
                sb.append(oneToThousandStr(num));
                break;
            }
        }

        return sb.toString().trim();
    }

    @Test
    public void mainTest() {
        log.info(numberToWords(100));
        int i = 0;
        while (i <= 2147483647) {
            log.info(i + ": " + numberToWords(i));
            i++;
        }
    }

    /**
     * 输出数字 1~999 的英文
     * @param num 1~999 的数字
     * @return 英文
     */
    private String oneToThousandStr(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= 100) {//百位
                sb.append(oneToNine[num / 100 - 1]);
                sb.append("Hundred ");
                num -= (num / 100 * 100);
            } else if (num >= 20) {//十位：大于等于20
                sb.append(twentyToNinety[num / 10 - 2]);
                num -= (num / 10 * 10);
            } else if (num >= 10) {//10~19
                sb.append(elevenToNineteen[num - 10]);
                break;
            } else if (num > 0) {
                sb.append(oneToNine[num - 1]);
                break;
            }
        }
        return sb.toString();
    }
}
