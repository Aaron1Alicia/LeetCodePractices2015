package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/22/15.
 */
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                break;
            }
        }

        if(fast==null || fast.next==null) {
            return null;
        }

        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
