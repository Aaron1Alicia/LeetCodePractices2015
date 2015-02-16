package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/13/15.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }

        if(l2==null) {
            return l1;
        }

        ListNode sf = new ListNode(0);
        ListNode ret = sf;

        int previous = 0;
        while(l1!=null && l2!=null) {
            ret.next = new ListNode(0);
            ret = ret.next;
            int tmp = l1.val+l2.val+previous;
            if(tmp>=10) {
                ret.val = tmp-10;
                previous = 1;
            } else {
                ret.val = tmp;
                previous = 0;
            }
            l1 = l1.next;
            l2 = l2.next;


        }

        ListNode left = l1!=null? l1:l2;
        while(left!=null) {
            ret.next = new ListNode(0);
            ret = ret.next;
            int tmp = left.val+previous;
            if(tmp>=10) {
                ret.val = tmp-10;
                previous = 1;
            } else {
                ret.val = tmp;
                previous = 0;
            }
            left = left.next;

        }

        if(previous==1) {
            ret.next = new ListNode(1);
        }

        return sf.next;
    }
}
