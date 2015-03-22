package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/1/15.
 */
@SuppressWarnings("unused")
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
            return null;
        }

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        int diff = Math.abs(lengthA-lengthB);
        if(lengthA>=lengthB) {
            while(diff>0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while(diff>0) {
                headB = headB.next;
                diff--;
            }
        }

        while(headA!=null && headB!=null) {
            if(headA==headB) {
                return headA;
            } else {
                headA=headA.next;
                headB=headB.next;
            }
        }

        return null;


    }


    private int getLength(ListNode node) {
        int length = 0;
        while(node!=null) {
            length++;
            node = node.next;
        }

        return length;
    }
}
