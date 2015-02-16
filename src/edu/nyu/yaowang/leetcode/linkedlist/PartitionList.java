package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/2/15.
 * 一条链表记录小的，一条链表记录大的。
 * 然后将两条链表连接起来
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode safeguard = new ListNode(0);
        ListNode last=safeguard;
        ListNode bigger = new ListNode(0);
        ListNode test = bigger;

        ListNode cur = head;

        while(cur!=null) {
            if(cur.val<x) {
                last.next = cur;
                cur = cur.next;
                last = last.next;
                last.next = null;
            } else {
                test.next = cur;
                cur = cur.next;
                test = test.next;
                test.next = null;
            }
        }

        last.next = bigger.next;
        return safeguard.next;

    }
}
