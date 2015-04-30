package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/2/15.
 * 单独一条链表记录大的那个部分,小的部分在原始的链表上操作,然后将两个表链接起来
 */
@SuppressWarnings("unused")
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode dummy2 = new ListNode(0);
        ListNode big = dummy2;
        ListNode cur = head;

        while(cur!=null) {
            if(cur.val>=x) {
                big.next = cur;
                cur = cur.next;
                //这里要连接上,不然小表就断了.
                pre.next = cur;
                big = big.next;
                big.next = null;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        pre.next = dummy2.next;
        return dummy.next;

    }
}
