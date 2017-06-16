package com.crazybunqnq.util;

/**
 * 时间工具集合
 * <p>
 * Created by CrazyBun on 2016/6/30.
 */
public class TimeUtil {
    public static long currentTime;

    public static void setCurrentTime() {
        currentTime = System.currentTimeMillis();
    }

    public static long runTime() {
        if (currentTime == 0) {
            return 0;
        }
        long timeCost = System.currentTimeMillis() - currentTime;
        currentTime = 999999999;
        return timeCost;
    }
}
