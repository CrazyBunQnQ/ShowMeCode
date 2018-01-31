package UtilTest;

import com.crazybunqnq.util.EncryptUtil;
import org.junit.Test;

/**
 * @version 2018/1/31.
 * @auther CrazyBunQnQ
 */
public class EncryptUtilTest {
    @Test
    public void test() {
        String str = "A19DF7CB3BAB397A9C8";
        System.out.println("input: " + str);
        String newStr = EncryptUtil.simpleEncryption(str, "chengyongyue", "199205312357");
        System.out.println("ouput: " + newStr);
        String oldStr = EncryptUtil.simpleDecryption(newStr, "chengyongyue", "199205312357");
        System.out.println("oldst: " + oldStr);
    }
}
