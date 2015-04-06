package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/21/15.
 * Redo, use safeguard to improve logic consistence
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null) {
            return head;
        }

        ListNode sf = new ListNode(0);
        sf.next = head;

        ListNode last = sf;

        ListNode slow = null;
        ListNode fast = null;

        while(last.next!=null && last.next.next!=null) {
            slow = last.next;
            fast = last.next.next;

            last.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            last = slow;

        }


        return sf.next;

    }
}
