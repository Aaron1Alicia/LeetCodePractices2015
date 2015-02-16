package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/1/15.
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
            return null;
        }

        ListNode tmpA = headA;
        ListNode tmpB = headB;

        int cntOfA = 0;
        while(headA!=null) {
            cntOfA++;
            headA = headA.next;
        }

        int cntOfB = 0;
        while(headB!=null) {
            cntOfB++;
            headB = headB.next;
        }

        if(cntOfB>=cntOfA) {
            int cnt = cntOfB-cntOfA;
            headB = tmpB;
            while(cnt>0) {
                headB = headB.next;
                cnt--;
            }
            headA=tmpA;

        } else {
            int cnt = cntOfA-cntOfB;
            headA = tmpA;
            while (cnt>0) {
                headA = headA.next;
                cnt--;
            }
            headB=tmpB;

        }


        while (headA!=null && headB!=null) {
            if(headA==headB) {
                return headA;
            } else {
                headB = headB.next;
                headA = headA.next;
            }
        }

        return null;

    }
}
