package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/21/15.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        //这一句是关键，因为Java里所有的instance都是引用，如果不在开始保存，后面修改first，就会修改head.next
        ListNode result = head.next;
        ListNode tmp;

        while(true) {
            tmp = second.next;
            second.next = first;
            if(tmp==null || tmp.next==null) {
                //这一句也很关键，如果长度不为2，那么就是下一个节点
                first.next=tmp;
                break;
            }
            // 下一个节点不是tmp, 而是tmp.next
            first.next = tmp.next;

            first=tmp;
            second=tmp.next;
        }


        return result;

    }
}
