package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/21/15.
 * Two pointers, one is ahead
 */
@SuppressWarnings("unused")
public class RomoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int i=0;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast=dummyNode;
        ListNode slow=dummyNode;

        while(i<n) {
            fast = fast.next;
            i++;
        }

        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
