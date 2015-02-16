package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/2/15.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) {
            return head;
        }
        ListNode sf = new ListNode(0);
        //sf.next = head;
        //ListNode pre = head;

        ListNode cur = head;

        while (cur!=null) {
            ListNode pre = sf;
            ListNode tmp = sf.next;
            while(tmp!=null && tmp.val<cur.val) {
                pre = tmp;
                tmp = tmp.next;
            }

            ListNode nextCur = cur.next;
            pre.next = cur;
            cur.next = tmp;
            cur = nextCur;

        }

        return sf.next;

    }
}
