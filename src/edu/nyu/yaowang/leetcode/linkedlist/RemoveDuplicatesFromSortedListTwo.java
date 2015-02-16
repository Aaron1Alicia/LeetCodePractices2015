package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/4/15.
 */
public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode sf = new ListNode(0);
        ListNode newList = sf;
        int cur = head.val;
        int count = 1;
        ListNode pre = head;
        head = head.next;

        // LittNode tmp;

        while (head != null) {
            if (head.val == cur) {
                count++;
            } else {
                if (count == 1) {
                    //newList.next =new ListNode(cur);
                    newList.next = pre;
                    newList = newList.next;


                }

                cur = head.val;
                pre = head;

                count = 1;

            }

            head = head.next;
        }

        if (count == 1) {
            newList.next = pre;
        }
        //这一句很重要，可以在最后去重，
        else {
            newList.next = null;
        }


        return sf.next;

    }

}
