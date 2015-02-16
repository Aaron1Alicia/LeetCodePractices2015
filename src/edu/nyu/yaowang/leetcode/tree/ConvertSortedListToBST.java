package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.ListNode;
import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 2/1/15.
 * 这一题必须要safe guard，否则无法将list的末尾
 * 置成null
 */


public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        }

        ListNode safeguard = new ListNode(0);
        safeguard.next = head;

        ListNode pre = safeguard;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            pre = pre.next;
        }

        TreeNode root = new TreeNode(pre.next.val);
        fast = pre.next.next;
        pre.next = null;
        root.left = sortedListToBST(safeguard.next);
        root.right = sortedListToBST(fast);
        return root;
    }
}
