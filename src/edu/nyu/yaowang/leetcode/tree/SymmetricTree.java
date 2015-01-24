package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/18/15.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {

        if(left==null && right==null) {
            return true;
        } else if(left!=null && right!=null && left.val==right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }

}
