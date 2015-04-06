package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/31/15.
 * 这一题如果用stack进行in_order traversal的话是可以很快解题，
 * 但是题目要求in-place, 而用stack的话其实是将list复制了一遍。
 * 因为stack会创建新的instance.
 * 这里有两种解法：
 * 1. DFS:其实DFS也会压栈
 * 2. iterative方法
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {

        if(root==null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;


        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;

        TreeNode cur = root;
        while(cur.right!=null) {
            cur = cur.right;
        }

        cur.right = right;

    }

    public void iterative(TreeNode root) {

        while(root!=null){
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode curr = root;
            //注意这里第一个curr.right其实是原来的左子树
            while(curr.right!=null){
                curr = curr.right;
            }
            curr.right = tmp;
            root = root.right;
        }

    }

}
