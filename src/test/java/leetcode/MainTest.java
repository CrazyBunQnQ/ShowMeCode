package leetcode;

import com.crazybunqnq.util.TimeUtil;
import org.junit.Test;

public class MainTest {

    @Test
    public void mainTest() {
        TimeUtil.setCurrentTime();
//        ReverseInteger.test();
        int f = 'f';
        System.out.println(Integer.toBinaryString(f));
        int m = 'm';
        System.out.println(Integer.toBinaryString(m));
        System.out.println(f + " " + m);
        int r = f ^ m;
        System.out.println(Integer.toBinaryString(r));

        int sex;
        sex = 'f';
        System.out.println(Integer.toBinaryString(r ^ sex));
        sex = 'm';
        System.out.println(Integer.toBinaryString(r ^ sex));
        System.out.println(TimeUtil.runTime());
    }

}
