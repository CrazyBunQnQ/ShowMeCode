package com.crazybunqnq.leetcode.easy;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * <p>
 * Given s = "hello", return "olleh".
 *
 * @author Administrator
 */
public class ReverseString {
    public String reverseString_2ms(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public String reverseString_5ms(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
}
