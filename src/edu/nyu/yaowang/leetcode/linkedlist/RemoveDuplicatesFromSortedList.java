package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/17/15.
 * 注意当前值和之前值相同时，不用更新pre
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return head;
        }

        int preValue = head.val;
        ListNode cur = head.next;
        ListNode pre = head;

        while(cur!=null) {
            if(cur.val!=preValue) {
                preValue = cur.val;
                pre = cur;

            } else {
                pre.next = cur.next;

            }
            cur = cur.next;


        }

        return head;
    }
}
