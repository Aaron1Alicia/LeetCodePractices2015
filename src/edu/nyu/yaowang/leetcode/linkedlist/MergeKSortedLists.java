package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

import java.util.List;

/**
 * Created by Yao on 2/15/15.
 * Divide and conquer
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==0) {
           return null;
        } else if(lists.size()==1){
            return lists.get(0);
        } else {
            return mergeTwoList(mergeKLists(lists.subList(0, lists.size()/2)),
                    mergeKLists(lists.subList(lists.size()/2, lists.size())));
        }

    }

    private ListNode mergeTwoList(ListNode p, ListNode q) {

        if(p==null) {
            return q;
        }

        if(q==null) {
            return p;
        }

        ListNode sf = new ListNode(0);
        ListNode head = sf;


        while (p!=null && q!=null) {

            if(p.val < q.val) {
                head.next = p;
                p = p.next;
                head = head.next;
                head.next = null;
            } else {
                head.next = q;
                q = q.next;
                head = head.next;
                head.next = null;
            }

        }

        if(p!=null) {
            head.next = p;
        } else {
            head.next = q;
        }

        return sf.next;

    }
}
