package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 2/14/15.
 */
public class BinaryTreeMaximumPathSum {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxValue;

    }
    public int maxPath(TreeNode root) {
        if(root==null) {
            return 0;
        } else {
            int leftMax = Math.max(0, maxPath(root.left));
            int rightMax = Math.max(0, maxPath(root.right));
            maxValue = Math.max(maxValue, leftMax+rightMax+root.val);
            return Math.max(leftMax, rightMax)+root.val;

        }

    }


}
