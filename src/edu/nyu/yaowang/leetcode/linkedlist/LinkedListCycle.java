package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/8/15.
 * 280 ms, two pointers, one moves faster, another moves slower
 */
@SuppressWarnings("unused")
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null) {

            if(slow==fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;
            if(fast!=null) {
                fast = fast.next;
            }

        }

        return false;
    }
}
