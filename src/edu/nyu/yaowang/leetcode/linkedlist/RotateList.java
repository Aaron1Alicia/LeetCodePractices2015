package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/13/15.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {

        if(head==null) {
            return null;
        }
        ListNode sf = new ListNode(0);
        sf.next = head;

        ListNode tmp = head;

        int len = 1;
        while(tmp.next!=null) {
            tmp = tmp.next;
            len++;
        }

        ListNode fast = head;
        ListNode slow = head;

        int cnt = n%len;

        while(cnt>0) {
            fast = fast.next;
            cnt--;
        }

        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = sf.next;
        sf.next = slow.next;
        slow.next = null;

        return sf.next;

    }
}
