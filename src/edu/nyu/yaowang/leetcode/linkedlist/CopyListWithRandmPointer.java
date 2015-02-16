package edu.nyu.yaowang.leetcode.linkedlist;

/**
 * Created by Yao on 2/14/15.
 * http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
 */
public class CopyListWithRandmPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) {
            return null;
        }

        RandomListNode sf = new RandomListNode(0);
        sf.next = head;

        RandomListNode cur = head;

        while(cur!=null) {
            RandomListNode tmp = cur.next;
            RandomListNode copyNode = new RandomListNode(cur.label);
            cur.next = copyNode;
            copyNode.next = tmp;
            cur = copyNode.next;
        }


        cur = sf.next;

        while(cur!=null) {
            if(cur.random!=null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        cur = sf.next;
        RandomListNode ret=cur.next;

        while(cur!=null && cur.next.next!=null) {
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = tmp.next.next;
            cur = cur.next;
        }

        if(cur!=null) {
            RandomListNode tmp = cur.next;
            cur.next=null;
            tmp.next = null;
        }

        return ret;

    }

     class RandomListNode {
             int label;
             RandomListNode next, random;
             RandomListNode(int x) { this.label = x; }
         };
}
