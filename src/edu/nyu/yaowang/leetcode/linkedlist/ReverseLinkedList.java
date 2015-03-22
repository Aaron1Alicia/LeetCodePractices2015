package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 1/8/15.
 * 思路：https://leetcodenotes.wordpress.com/2013/10/11/leetcode-reverse-linked-list-2-%E6%8A%8A%E5%8D%95%E9%93%BE%E8%A1%A8%E7%AC%ACm%EF%BD%9En%E4%B8%AA%E7%BB%99inplace%E5%8F%8D%E8%BD%AC%E5%85%B6%E4%BB%96%E4%B8%8D%E5%8F%98/
 * 这个解法的思路是往里面插值，非常巧妙, 如果只是单纯的reverse的话，可以采用别的解法
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevM = dummy;
        ListNode prev=null;
        ListNode curr=null;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                prevM = prevM.next;
            } else if (i == m) {
                prev = prevM.next;
                curr = prev.next;
            }else {
                prev.next = curr.next;
                curr.next = prevM.next;
                prevM.next = curr;
                curr = prev.next;
            }
        }
        return dummy.next;
    }
}
