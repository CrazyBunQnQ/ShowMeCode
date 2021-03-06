package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * We are given a personal information string S, which may represent either an email address or a phone number.
 * <p>
 * We would like to mask this personal information according to the following rules:
 * <p>
 * <p>
 * 1. Email address:
 * <p>
 * We define a name to be a string of length ≥ 2 consisting of only lowercase letters a-z or uppercase letters A-Z.
 * <p>
 * An email address starts with a name, followed by the symbol '@', followed by a name, followed by the dot '.' and followed by a name.
 * <p>
 * All email addresses are guaranteed to be valid and in the format of "name1@name2.name3".
 * <p>
 * To mask an email, all names must be converted to lowercase and all letters between the first and last letter of the first name must be replaced by 5 asterisks '*'.
 * <p>
 * <p>
 * 2. Phone number:
 * <p>
 * A phone number is a string consisting of only the digits 0-9 or the characters from the set {'+', '-', '(', ')', ' '}. You may assume a phone number contains 10 to 13 digits.
 * <p>
 * The last 10 digits make up the local number, while the digits before those make up the country code. Note that the country code is optional. We want to expose only the last 4 digits and mask all other digits.
 * <p>
 * The local number should be formatted and masked as "***-***-1111", where 1 represents the exposed digits.
 * <p>
 * To mask a phone number with country code like "+111 111 111 1111", we write it in the form "+***-***-***-1111".  The '+' sign and the first '-' sign before the local number should only exist if there is a country code.  For example, a 12 digit phone number mask should start with "+**-".
 * <p>
 * Note that extraneous characters like "(", ")", " ", as well as extra dashes or plus signs not part of the above formatting scheme should be removed.
 * <p>
 * <p>
 * <p>
 * Return the correct "mask" of the information provided.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "LeetCode@LeetCode.com"
 * Output: "l*****e@leetcode.com"
 * Explanation: All names are converted to lowercase, and the letters between the
 * first and last letter of the first name is replaced by 5 asterisks.
 * Therefore, "leetcode" -> "l*****e".
 * Example 2:
 * <p>
 * Input: "AB@qq.com"
 * Output: "a*****b@qq.com"
 * Explanation: There must be 5 asterisks between the first and last letter
 * of the first name "ab". Therefore, "ab" -> "a*****b".
 * Example 3:
 * <p>
 * Input: "1(234)567-890"
 * Output: "***-***-7890"
 * Explanation: 10 digits in the phone number, which means all digits make up the local number.
 * Example 4:
 * <p>
 * Input: "86-(10)12345678"
 * Output: "+**-***-***-5678"
 * Explanation: 12 digits, 2 digits for country code and 10 digits for local number.
 * Notes:
 * <p>
 * S.length <= 40.
 * Emails have length at least 8.
 * Phone numbers have length at least 10.
 *
 * @version 2018/5/6.
 * @Score 5
 * @auther CrazyBunQnQ
 */
public class MaskingPersonalInformation {
    String[] country = {"", "+*-", "+**-", "+***-"};

    /**
     * If the string is a email then it will be mosaic
     */
    public String maskEmail(String email) {
        String rexEmail = "[a-zA-Z]{2,}@[a-zA-Z]{2,}\\.[a-zA-Z]{2,}";
        if (Pattern.matches(rexEmail, email)) {
            String[] arr = email.split("@");
            String name = arr[0];
            name = name.charAt(0) + "*****" + name.charAt(name.length() - 1);
            return name.toLowerCase() + "@" + arr[1].toLowerCase();
        }
        return null;
    }

    /**
     * If the string is a phone number then it will be mosaic
     */
    public String maskPhone(String phone) {
        String rexChar = "[+\\-\\(\\) ]";
        String rexNum = "\\d{10,13}";
        String number = phone.replaceAll(rexChar, "");
        if (Pattern.matches(rexNum, number)) {
            if (number.length() > 10) {
                StringBuilder code = new StringBuilder("+*");
                for (int i = 1; i < number.length() - 10; i++) {
                    code.append("*");
                }
                return code.toString() + "-***-***-" + number.substring(number.length() - 4);
            } else {
                return "***-***-" + number.substring(number.length() - 4);
            }
        }
        return null;
    }

    public String maskPII(String S) {
        String result = maskEmail(S);
        if (result != null) {
            return result;
        }
        result = maskPhone(S);
        if (result != null) {
            return result;
        }
        return null;
    }

    public String maskPII_EasyAndConcise(String S) {
        int at = S.indexOf("@");
        if (at > 0) {
            S = S.toLowerCase();
            return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }

    @Test
    public void test() {
        System.out.println(maskPII("CrazyBunQnQ@gmail.com"));
        System.out.println(maskPII("BUN@gmail.com"));
        System.out.println(maskPII("+1(805)-666-2814"));
        System.out.println(maskPII("1(234)567-890"));
        System.out.println(maskPII("86-(10)12345678"));
        System.out.println(maskPII("+(501321)-50-23431"));
    }
}
