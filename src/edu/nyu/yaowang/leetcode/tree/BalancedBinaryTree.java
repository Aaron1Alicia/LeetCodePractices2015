package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/17/15.
 * 257ms, 这一题的要点是用树的深度来兼职作为树是否balanced的标志, 这样可以将递归问题转换为DFS，
 * 将时间复杂度从NlogN降到logN
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return (root==null) || isBalanced(root.left, root.right, 1)>0;

    }

    // return the depth of subTree if it is balanced, else return -1
    public int isBalanced(TreeNode left, TreeNode right, int depth) {
        int leftDepth = left==null? depth: isBalanced(left.left, left.right, depth+1);
        int rightDepth = right==null? depth: isBalanced(right.left, right.right, depth+1);

        if(Math.min(leftDepth, rightDepth)==-1){
            return -1;
        }else if(Math.abs(leftDepth-rightDepth)>1) {
            return -1;
        }else {
            return Math.max(leftDepth,rightDepth);
        }

    }
}
