package edu.nyu.yaowang.leetcode.miscellaneous;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/7/15.
 * 259ms
 */

@SuppressWarnings("unused")
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // Fake head to simplify logic
        ListNode head= new ListNode(-1);
        ListNode cur =head;

        while(l1!=null && l2!=null) {
            if(l1.val> l2.val) {
                cur.next=l2;
                l2=l2.next;

            } else {
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }

        if(l1!=null) {
            cur.next=l1;
        }else{
            cur.next=l2;
        }

        return head.next;
    }
}
