package leet.code;

import com.crazybunqnq.leetcode.easy.ReverseInteger;
import com.crazybunqnq.util.TimeUtil;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void mainTest(String[] args) {
        TimeUtil.setCurrentTime();
        ReverseInteger.test();
        System.out.println(TimeUtil.runTime());
    }

}
