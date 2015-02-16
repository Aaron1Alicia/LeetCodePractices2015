package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/15/15.
 */
public class ReorderList {
    public void reorderList(ListNode head) {

        if(head == null || head.next ==null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next;
            if(fast.next!=null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }

        ListNode left = head;

        ListNode right = slow.next;
        slow.next = null;
        right = reverse(right);
        merge(left, right);

    }


    private ListNode reverse(ListNode head) {

        ListNode pre = null;


        while(head!=null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        return pre;

    }

    private void merge(ListNode left, ListNode right) {
        while(left!=null && right!=null) {
            ListNode tmp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = tmp;
        }

    }
}
