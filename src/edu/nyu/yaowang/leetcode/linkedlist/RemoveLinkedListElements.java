package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 4/22/15.
 */
@SuppressWarnings("unused")
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while(cur!=null) {
            if(cur.val==val) {
                pre.next = cur.next;
                cur = cur.next;
                continue;
            }

            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
