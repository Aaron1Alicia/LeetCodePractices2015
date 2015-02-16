package edu.nyu.yaowang.leetcode.linkedlist;

import edu.nyu.yaowang.leetcode.ListNode;

/**
 * Created by Yao on 2/13/15.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode sf = new ListNode(0);
        sf.next = head;

        ListNode pre = sf;
        ListNode cur = head;
        int cnt = k;

        while(cur!=null) {

            while(cur!=null && cnt>1) {
                cur = cur.next;
                cnt--;
            }

            if(cur==null) {
                break;
            }

            cur = pre.next;
            cnt = k;

            //保持cur不动，不停向里面插值
            while(cnt>1) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
                cnt--;
            }

            pre = cur;
            cur = pre.next;
            cnt = k;


        }

        return sf.next;



    }
}
