package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/16/15.
 */
@SuppressWarnings("unused")
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        //注意两个node的base case
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = sortList(head);
        head2 = sortList(head2);
        ListNode ret = merge(head1, head2);
        return ret;

    }


    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode helper = new ListNode(0);
        ListNode head = helper;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                head.next = head1;
                head1 = head1.next;
            }
            else
            {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        head.next = head1!=null? head1:head2;

        return helper.next;
    }

}
