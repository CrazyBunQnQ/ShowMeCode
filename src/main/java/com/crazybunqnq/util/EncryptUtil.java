package com.crazybunqnq.util;

/**
 * @version 2018/1/31.
 * @auther CrazyBunQnQ
 */
public class EncryptUtil {

    private EncryptUtil() {

    }

    public static String simpleEncryption(String message, String str, String num) {
        try {
            Long.valueOf(num);
        } catch (Exception e) {
            return "The third parameter must be the number.";
        }
        if (message.length() < 10) {
            return "Only 10 bits of string can be encrypted.";
        }
        if (str.length() != num.length()) {
            return "The length of the string should be the same as the length of the number.";
        }
//        String result = message.toUpperCase();
        String result = message;
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            int n = Integer.valueOf(String.valueOf(num.charAt(i)));
            n = n == 0 ? 10 : n;
//            System.out.println((int)str.charAt(i));
//            System.out.print("char " + result.charAt(n - 1) + " → ");
            int a = charToByte(result.charAt(n - 1)) + (int) str.charAt(i) % 16;
//            System.out.print(a%16 + " → ");
            tmp = String.valueOf(byteToChar((byte) (a % 16)));
//            System.out.println(tmp);
            result = result.substring(0, n - 1) + result.substring(n) + tmp;
        }
        return result;
    }

    public static String simpleDecryption(String message, String str, String num) {
        try {
            Long.valueOf(num);
        } catch (Exception e) {
            return "The third parameter must be the number.";
        }
        if (message.length() < 10) {
            return "Only 10 bits of string can be Decrypted.";
        }
        if (str.length() != num.length()) {
            return "The length of the string should be the same as the length of the number.";
        }
//        String result = message.toUpperCase();
        String result = message;
        String tmp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            int n = Integer.valueOf(String.valueOf(num.charAt(i)));
            n = n == 0 ? 10 : n;
//            System.out.print("char " + result.charAt(result.length() - 1) + " → ");
            int a = charToByte(result.charAt(result.length() - 1)) + 16 - str.charAt(i) % 16;
            tmp = String.valueOf(byteToChar((byte) (a % 16)));
//            System.out.println(tmp);
            result = result.substring(0, n - 1) + tmp + result.substring(n - 1, result.length() - 1);
        }
        return result;
    }

    private static byte charToByte(char c) {
        c = Character.toUpperCase(c);
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    private static char byteToChar(byte b) {
        return "0123456789ABCDEF".charAt(b);
    }
}
