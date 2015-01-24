package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/22/15.
 */
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;

            if(fast!=null) {
                fast = fast.next;
            } else {
                return null;
            }
            if(slow==fast) {
                slow=head;
                while(slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }

        return null;

    }
}
