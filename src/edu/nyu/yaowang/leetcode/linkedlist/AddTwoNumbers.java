package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/13/15.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(l1!=null && l2!=null) {
            int value = 0;
            value = l1.val+l2.val+pre;
            if(value>=10) {
                value = value-10;
                pre = 1;
            } else {
                pre = 0;
            }
            ListNode newNode = new ListNode(value);
            head.next = newNode;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode left = l1!=null?l1:l2;
        while(left!=null) {
            int value = left.val+pre;
            if(value>=10) {
                value-=10;
                pre = 1;
            } else {
                head.next = left;
                left.val = value;
                return dummy.next;
            }

            ListNode newNode = new ListNode(value);
            head.next = newNode;
            head = head.next;
            left = left.next;
        }

        if(pre==1) {
            head.next = new ListNode(1);
        }


        return dummy.next;
    }
}
