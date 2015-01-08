package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/6/15.
 */
/*
  Use recursion, Get the depth of the left tree and the depth of the right tree.
  Find max between these two and do not forget to add 1 to the result.
 */
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int depthLeft=0;
        int depthRight=0;

        if(root.left != null) {
           depthLeft = maxDepth(root.left);
        }

        if(root.right != null) {
           depthRight = maxDepth(root.right);
        }

        return Math.max(depthLeft,depthRight)+1;
    }
}
