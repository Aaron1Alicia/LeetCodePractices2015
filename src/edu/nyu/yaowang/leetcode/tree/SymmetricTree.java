package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    /*
     一般tree的iterative解法就是BFS或者stack来辅助
     */
    public boolean isSymmetricIterative(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        } else if(root.left!=null && root.right==null) {
            return false;
        } else if(root.left==null && root.right!=null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(root.left);
        q2.add(root.right);


        while(!q1.isEmpty() && !q2.isEmpty()) {

            TreeNode left = q1.poll();
            TreeNode right = q2.poll();

            if(left.val!=right.val) {
                return false;
            }

            if((left.left!=null && right.right==null) || (left.left==null && right.right!=null)) {
                return false;
            }

            if((left.right!=null && right.left==null) ||(left.right==null && right.left!=null)) {
                return false;
            }

            if(left.left!=null) {
                q1.add(left.left);
                q2.add(right.right);
            }

            if(right.left!=null) {
                q1.add(left.right);
                q2.add(right.left);

            }

        }

        return true;
    }

}
