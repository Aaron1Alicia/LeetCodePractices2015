package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yao on 1/8/15.
 */
@SuppressWarnings("unused")
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        long previous = Long.MIN_VALUE;

        while(!st.isEmpty() || cur!=null) {

            if(cur!=null) {
                st.push(cur) ;
                cur = cur.left;
            } else {
                cur = st.pop();
                if(cur.val<=previous) {
                    return false;
                }
                previous = cur.val;
                cur = cur.right;
            }

        }

        return true;

    }

    public boolean isValidBST_MINMAX(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }


    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root==null) {
            return true;
        }

        if((long)root.val<=min || (long)root.val>=max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
