package UtilTest;

import com.crazybunqnq.util.FileUtil;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @version 2017/10/17.
 * @auther CrazyBunQnQ
 */
@Log4j
public class FileStringConvertTest {

    @Test
    public void test() throws IOException {
//        FileUtil.file2Text("/Users/baojunjie/Desktop/test/f2t.mp4","/Users/baojunjie/Desktop/test/f2t.txt",5000);
        FileUtil.text2File("/Users/baojunjie/Desktop/test/f2t2.mp4","/Users/baojunjie/Desktop/test/f2t.txt");
    }
}
