package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/17/15.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;

        //
        int curValue= head.val;
        ListNode cur = head.next;
        ListNode pre = head;

        while(cur!=null) {
            if(cur.val== curValue) {
                pre.next = cur.next;
                cur = pre.next;

            }
            else {
                curValue=cur.val;
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
