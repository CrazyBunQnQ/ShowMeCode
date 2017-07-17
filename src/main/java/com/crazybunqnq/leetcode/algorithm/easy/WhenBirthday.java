package com.crazybunqnq.leetcode.algorithm.easy;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void testGetCherylsBirthday() {
        log.info("Cheryl 给出的十个可能的生日：" + DATES.toString());
        String birthday = getCherylsBirthday(DATES);
        if ("".equals(birthday)) {
            log.warn("无法得知 Cheryl 的生日。");
            return;
        }
        log.info("Cheryl 告诉 Albert 自己生日的月份是 " + getMonth(birthday));
        log.info("Cheryl 告诉 Bernard 自己生日的日是 " + getDay(birthday));
        log.info("Cheryl 的生日是：" + birthday);
    }

    /**
     * Albert 的第一句话可分解为：
     * <p>
     * 在 Cheryl 告诉我她生日中的月份时，我不知道她的生日，我也不知道她告诉 Bernard 的是哪一天，但是我知道所有可能的日子。
     * <p>
     * 如果 Bernard 被告知了那个日子，他也不可能知道她的生日。
     *
     * @param date
     *
     * @return
     */
    private boolean statementAlbertFirst(String date) {
        /**
         * 如果 Cheryl 告诉 Bernard 日子之后 Bernard 还不知道生日的花，意味着那个日子在给出的十个日期中不是独一无二的。
         *
         * 这意味着 Albert 知道月份，并且知道可能的日子但是 Bernard 不知道。
         */
        boolean temp = true;

        List<String> possibleDates = tell(getMonth(date));

        for (int i = 0; i < possibleDates.size(); i++) {
            //
            if (hasKnow(tell(getDay(possibleDates.get(i))))) {
                temp = false;
                break;
            }
        }

        return !hasKnow(possibleDates) && temp;
    }

    /**
     * Bernard 的花可以分解为：
     * <p>
     * 一开始 Cheryl 告诉我这个日子的时候我不知道具体的生日。
     * <p>
     * 但我经过深思熟虑后，Cheryl 的生日只可能是经过 Albert 的第一句话判断后是真的日期
     *
     * @param date
     *
     * @return
     */
    private boolean statementBernard(String date) {
        List<String> atFirst = tell(getDay(date));

        //深思熟虑
        List<String> filterItem = new ArrayList<String>();
        for (String item : atFirst) {
            if (statementAlbertFirst(item)) {
                filterItem.add(item);
            }
        }

        //最开始不知道，但现在知道了
        return !hasKnow(atFirst) && hasKnow(filterItem);
    }

    /**
     * Albert：现在我也知道 Cheryl 的生日了
     *
     * @param date
     *
     * @return
     */
    private boolean statementAlbertLast(String date) {
        List<String> list = tell(getMonth(date));

        //Bernard 说完后经过思考
        List<String> filterItem = new ArrayList<String>();
        for (String item : list) {
            if (statementBernard(item)) {
                filterItem.add(item);
            }
        }

        //我也知道了
        return hasKnow(filterItem);
    }

    /**
     * 三句话如果都是真的，则该日期就是 Cheryl 的生日
     *
     * @param date
     *
     * @return
     */
    private boolean statementAllTrue(String date) {
        return statementAlbertFirst(date) && statementBernard(date) && statementAlbertLast(date);
    }

    private List<String> tell(String partOfBirthday) {
        char first = partOfBirthday.charAt(0);
        List<String> possibleList = new ArrayList<String>();

        //如果得知的是月份
        if (first >= 'A' && first <= 'Z') {
            for (String date : DATES) {
                if (partOfBirthday.equals(getMonth(date))) {
                    possibleList.add(date);
                }
            }
        } else {//如果得知的是日
            for (String date : DATES) {
                if (partOfBirthday.equals(getDay(date))) {
                    possibleList.add(date);
                }
            }
        }
        return possibleList;
    }

    /**
     * 得知 Cheryl 的生日
     *
     * @param dates
     *
     * @return
     */
    private String getCherylsBirthday(String[] dates) {
        String birthday = "";
        for (String date : dates) {
            if (statementAllTrue(date)) {
                birthday = date;
                break;
            }
        }

        return birthday;
    }


    /**
     * 知道生日了（只有一个可能的生日）
     *
     * @param dateList
     *
     * @return
     */
    private boolean hasKnow(List<String> dateList) {
        return dateList.size() == 1;
    }

    /**
     * 获取月
     *
     * @param date
     *
     * @return
     */
    private String getMonth(String date) {
        return date.split(" ")[0];
    }

    /**
     * 获取日
     *
     * @param date
     *
     * @return
     */
    private String getDay(String date) {
        return date.split(" ")[1];
    }
}
