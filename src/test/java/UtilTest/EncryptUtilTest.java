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
        String str = "8wnuXAaU34JN8AdpzyXybnxQqw8i7c7x3BCX7CZmkddupufzD3HoAxfzaZVQQqGx";
        System.out.println("input: " + str);
        String newStr = EncryptUtil.simpleEncryption(str, "MyFriend", "19930717").toLowerCase();
        System.out.println("ouput: " + newStr);
        String oldStr = EncryptUtil.simpleDecryption(newStr, "MyFriend", "19930717").toLowerCase();
        System.out.println("oldst: " + oldStr);

        System.out.println(str.equalsIgnoreCase(oldStr)?"测试成功":"解密失败");

//        Object proxyObject = Proxy.newProxyInstance()
    }
}
