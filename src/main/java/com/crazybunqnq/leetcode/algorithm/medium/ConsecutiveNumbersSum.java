package com.crazybunqnq.leetcode.algorithm.medium;

import com.crazybunqnq.util.TimeUtil;
import org.junit.Test;

/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * Note: 1 <= N <= 10 ^ 9.
 *
 * @version 2018/5/6.
 * @Score 7
 * @auther CrazyBunQnQ
 */
public class ConsecutiveNumbersSum {
    /**
     * Sn = (a1 + an) * n / 2 = N
     * <p>
     * a1 + an = Sn * 2 / n 整数
     * <p>
     * d = (an - a1) / (n - 1) = 1
     *
     * @param N
     *
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int result = 1;//结果
        int n = 2;//项数
        int a1;//首项
        int an;//末项
        int d;//公差
        int Sn;//和

//        while (n <= Math.ceil((double) N / 2)) {
        while (n <= Math.ceil((double) N / 2) && (double) N / n / n > 0.4) {
            // 首项加末项一定是整数
            if (N * 2 % n != 0) {
                n++;
//                System.out.println("n = " + n + "    Sn/n = " + N / n + "    Sn/n/n = " + (double) N / n / n);
                continue;
            }
            int am = N / n;//是中间数
            if (N % n == 0) {
                int m = (n - 1) / 2;//中间数下标
                if (m == 0) {//下标必须是整数
                    n++;
//                    System.out.println("n = " + n + "    Sn/n = " + N / n + "    Sn/n/n = " + (double) N / n / n);
                    continue;
                }
                a1 = am - m;
                if (a1 <= 0) {
                    n++;
//                    System.out.println("n = " + n + "    Sn/n = " + N / n + "    Sn/n/n = " + (double) N / n / n);
                    continue;
                }
                an = am + m;
            } else {
                int m1 = n / 2 - 1;
                a1 = am - m1;
                if (a1 <= 0) {
                    n++;
//                    System.out.println("n = " + n + "    Sn/n = " + N / n + "    Sn/n/n = " + (double) N / n / n);
                    continue;
                }
                an = am + 1 + m1;
            }
            Sn = (a1 + an) * n / 2;
            d = (an - a1) / (n - 1);
            if (N == Sn && d == 1) {
                result++;
            }
            n++;
//            System.out.println("n = " + n + "    Sn/n = " + N / n + "    Sn/n/n = " + (double) N / n / n);
        }
        return result;
    }

    @Test
    public void test() {
        for (int i = 1; i <= Math.pow(10, 9); i = i + (int) (Math.random() * 10000)) {
            TimeUtil.setCurrentTime();
            System.out.println("N = " + i + ": " + consecutiveNumbersSum(i) + "个，耗时 " + TimeUtil.runTime() + " 毫秒");
        }
        /*System.out.println("N = 2: " + consecutiveNumbersSum(1) + "；应该是 1");
        System.out.println("N = 2: " + consecutiveNumbersSum(2) + "；应该是 1");
        System.out.println("N = 3: " + consecutiveNumbersSum(3) + "；应该是 2");
        System.out.println("N = 4: " + consecutiveNumbersSum(4) + "；应该是 1");
        System.out.println("N = 5: " + consecutiveNumbersSum(5) + "；应该是 2");
        System.out.println("N = 6: " + consecutiveNumbersSum(6) + "；应该是 2");
        System.out.println("N = 7: " + consecutiveNumbersSum(7) + "；应该是 2");
        System.out.println("N = 8: " + consecutiveNumbersSum(8) + "；应该是 1");
        System.out.println("N = 9: " + consecutiveNumbersSum(9) + "；应该是 3");
        System.out.println("N = 10: " + consecutiveNumbersSum(10) + "；应该是 2");
        System.out.println("N = 11: " + consecutiveNumbersSum(11) + "；应该是 2");
        System.out.println("N = 12: " + consecutiveNumbersSum(12) + "；应该是 2");
        System.out.println("N = 13: " + consecutiveNumbersSum(13) + "；应该是 2");
        System.out.println("N = 14: " + consecutiveNumbersSum(14) + "；应该是 2");
        System.out.println("N = 15: " + consecutiveNumbersSum(15) + "；应该是 4");
        System.out.println("N = 16: " + consecutiveNumbersSum(16) + "；应该是 2");
        System.out.println("N = 17: " + consecutiveNumbersSum(17) + "；应该是 2");
        System.out.println("N = 18: " + consecutiveNumbersSum(18) + "；应该是 2");
        System.out.println("N = 19: " + consecutiveNumbersSum(19) + "；应该是 2");
        TimeUtil.setCurrentTime();
        System.out.println("N = 3772593: " + consecutiveNumbersSum(3772593) + "；应该是 24，原耗时 10 毫秒，本次耗时 " + TimeUtil.runTime() + " 毫秒");
        TimeUtil.setCurrentTime();
        System.out.println("N = 120034350: " + consecutiveNumbersSum(120034350) + "；应该是 35，原耗时 10 毫秒，本次耗时 " + TimeUtil.runTime() + " 毫秒");
        TimeUtil.setCurrentTime();
        System.out.println("N = 119609750: " + consecutiveNumbersSum(119609750) + "；应该是 45，原耗时 10 毫秒，本次耗时 " + TimeUtil.runTime() + " 毫秒");
        TimeUtil.setCurrentTime();
        System.out.println("N = 119612350: " + consecutiveNumbersSum(119612350) + "；应该是 23，原耗时 10 毫秒，本次耗时 " + TimeUtil.runTime() + " 毫秒");
        TimeUtil.setCurrentTime();
        System.out.println("N = 119623491: " + consecutiveNumbersSum(119623491) + "；应该是 46，原耗时 10 毫秒，本次耗时 " + TimeUtil.runTime() + " 毫秒");
        TimeUtil.setCurrentTime();
        System.out.println("N = 119634975: " + consecutiveNumbersSum(119634975) + "；应该是 70，原耗时 10 毫秒，本次耗时 " + TimeUtil.runTime() + " 毫秒");*/
    }
}
