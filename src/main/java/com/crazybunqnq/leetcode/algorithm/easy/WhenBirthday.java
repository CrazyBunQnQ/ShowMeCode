package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;

import java.util.List;

/**
 * Alert 和 Bernard 刚刚结交了新朋友 Cheryl，并且他们想知道 Cheryl 的生日是何时。Cheryl 给了他们十个可能的生日：
 * <p>
 * May 15,May 16,May 19,June 17,June 18,July 14,July 16,August 14,August 15,August 17
 * <p>
 * 之后 Cheryl 将生日的月份和日子分别告诉了 Albert 和 Bernard（Albert 只知道月份，Bernard 只知道日子。
 * <p>
 * Albert：我不知道 Cheryl 的生日是什么时候，但是我知道 Bernard 也不知道。
 * <p>
 * Bernard：最开始我不知道 Cheryl 的生日是什么时候，但是我现在知道了。
 * <p>
 * Albert：现在我也知道 Cheryl 的生日是什么时候了。
 * <p>
 * 那么，Cheryl 的生日是什么时候？
 *
 * @version 2017/7/10.
 * @auther CrazyBunQnQ
 */
@Log4j
public class WhenBirthday {
    public static final String[] DATES = {"May 15", "May 16", "May 19", "June 17", "June 18", "July 14", "July 16", "August 14", "August 15", "August 17"};

    private List<String> tell(String partOfBirthday) {
        return null;
    }

    private boolean hasKnow(List<String> dateList) {
        return dateList.size() == 1;
    }

    private String getMonth(String date) {
        return date.split(" ")[0];
    }

    private String getDay(String date) {
        return date.split(" ")[1];
    }
}
