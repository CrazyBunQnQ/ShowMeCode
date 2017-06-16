package leetcode;

import com.crazybunqnq.leetcode.algorithm.easy.ReverseInteger;
import com.crazybunqnq.util.TimeUtil;
import org.junit.Test;

public class MainTest {

    @Test
    public void mainTest(String[] args) {
        TimeUtil.setCurrentTime();
        ReverseInteger.test();
        System.out.println(TimeUtil.runTime());
    }

}
