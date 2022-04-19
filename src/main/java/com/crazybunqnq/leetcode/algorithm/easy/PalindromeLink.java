package com.crazybunqnq.leetcode.algorithm.easy;

import java.util.Stack;

/**
 * 回文链表
 *
 * @author baojunjie
 * @date 2021/11/19
 */
public class PalindromeLink {
    private Stack<Integer> leftStack;

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
