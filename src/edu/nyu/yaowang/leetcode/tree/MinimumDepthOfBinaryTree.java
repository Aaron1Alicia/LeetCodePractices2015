package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/21/15.
 * 注意tree的leaf的定义是既没有left child，也没有right child. 所以如果必须到达一个这样的node, 才算是到了leaf
 *
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }

        if(root.left==null && root.right==null) {
            return 1;
        }

        if(root.left == null) {
            return minDepth(root.right)+1;
        } else if(root.right == null) {
            return minDepth(root.left)+1;
        } else {
            return Math.min(minDepth(root.right), minDepth(root.left))+1;
        }

    }
}
