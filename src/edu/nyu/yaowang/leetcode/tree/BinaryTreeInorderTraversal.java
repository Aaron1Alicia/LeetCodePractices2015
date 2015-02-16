package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yao on 1/8/15.
 * Recursion version: 203ms,
 * Iterative version: 193ms
 * Iterative version解题思路，遇到node, 先push, 然后traverse左子树。如果左边没有，那么visit这个node, 然后
 * traverse右节点的子树。
 *
 * Morris traversal方法：http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
 */
@SuppressWarnings("unused")
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        inorderRecursion(root, ret);
        return ret;
    }

    public void inorderRecursion(TreeNode root, List<Integer> ret) {
        if(root==null) {
            return;
        }
        inorderRecursion(root.left, ret);
        ret.add(root.val);
        inorderRecursion(root.right, ret);
    }

    @SuppressWarnings("unused")
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        // This stack is used to store those nodes that have lower priority
        // according to inorder traversal
        Stack<TreeNode> formerNodes = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !formerNodes.isEmpty()) {
            if(cur != null) {
                formerNodes.push(cur);
                cur=cur.left;
            } else {
                cur = formerNodes.pop();
                ret.add(cur.val);
                cur = cur.right;
            }

        }

        return ret;
    }

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;

        while(cur!=null) {
            if(cur.left==null) {
                ret.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;

                while(pre.right!=null && pre.right!=cur) {
                    pre = pre.right;
                }
                if(pre.right==null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    ret.add(cur.val);
                    cur = cur.right;
                }

            }

        }

        return ret;
    }

}
