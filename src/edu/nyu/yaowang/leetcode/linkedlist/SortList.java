package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/16/15.
 */
public class SortList {
    public ListNode sortList(ListNode head) {

        return mergeSort(head);
    }


    private ListNode mergeSort(ListNode head) {
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
        ListNode head1 = mergeSort(head);
        head2 = mergeSort(head2);
        ListNode ret = merge(head1, head2);
        return ret;

    }


    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode helper = new ListNode(0);
        helper.next = head1;
        ListNode pre = helper;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                head1 = head1.next;
            }
            else
            {
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        if(head2!=null)
        {
            pre.next = head2;
        }
        return helper.next;
    }

}
