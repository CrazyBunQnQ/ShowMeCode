package com.crazybunqnq.util;

/**
 * 字符串工具集合
 * <p>
 * Created by CrazyBun on 2016/6/30.
 */
public class StringUtil {
    /**
     * 反转字符串，效率比StringBuffer.reverse快一倍
     *
     * @param s
     *
     * @return
     */
    public static String stringReverse(String s) {
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

    /**
     * 将字符串中的特殊字符转为 HTML 字符
     *
     * @param src
     *
     * @return
     */
    public static String doc2Html(String src) {
        if (src == null) {
            return null;
        }
        String s = src;
        s = replaceAll(s, "&", "&amp;");
        s = replaceAll(s, "<", "&lt;");
        s = replaceAll(s, ">", "&gt;");
        s = replaceAll(s, "\r\n", "<br>");
        s = replaceAll(s, "\n", "<br>");
        s = replaceAll(s, "\"", "&quot;");
        s = replaceAll(s, "'", "&#39;");
        return s;
    }

    /**
     * 将原字符串 src 中的所有字符串 astr 替换成 bstr
     *
     * @param src  原字符串
     * @param astr 需要替换的字符串
     * @param bstr 替换为此字符串
     *
     * @return 替换后的字符串
     */
    public static String replaceAll(String src, String astr, String bstr) {
        int i;
        StringBuffer sb = new StringBuffer();
        do {
            i = src.indexOf(astr);
            if (i == -1) {
                sb.append(src);
            } else {
                sb.append(src.substring(0, i));
                sb.append(bstr);
                src = src.substring(i + astr.length());
            }
        } while (i != -1);
        return sb.toString();
    }

    /**
     * 判断是否是 Emoji 字符
     *
     * @param codePoint
     *
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 过滤 Emoji 或者其他非文字类型（4个字节）的字符
     *
     * @param source
     *
     * @return
     */
    public static String filterEmoji(String source) {
        StringBuilder buf = null;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }
        if (buf == null) {
            return source;
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }
}
