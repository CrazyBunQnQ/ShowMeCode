package com.crazybunqnq.leetcode.algorithm.medium;

import org.junit.Test;

/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * <p>
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)
 * <p>
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student​​​​​​​ sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
 * ​​​​​​​
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 *
 * @version 2018/6/17.
 * @Score 6
 * @auther CrazyBunQnQ
 */
public class ExamRoom {
    public ExamRoom(int N) {

    }

    public int seat() {
        return 0;
    }

    public void leave(int p) {

    }

    @Test
    public void test() {

    }
}
