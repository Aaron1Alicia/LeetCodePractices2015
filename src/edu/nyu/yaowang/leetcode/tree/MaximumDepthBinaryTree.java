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
        else {
            int left =  maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}
