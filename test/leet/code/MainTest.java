package leet.code;

import com.crazybunqnq.easy.ReverseInteger;
import com.crazybunqnq.utils.TimeUtil;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void mainTest(String[] args) {
        TimeUtil.setCurrentTime();
        ReverseInteger.test();
        System.out.println(TimeUtil.runTime());
    }

}
