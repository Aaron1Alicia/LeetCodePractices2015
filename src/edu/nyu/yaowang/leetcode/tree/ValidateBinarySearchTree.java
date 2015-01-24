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

        while(!st.isEmpty() || cur!=null) {

            if(cur!=null) {
                st.push(cur) ;
                cur = cur.left;
            } else {
                cur = st.pop();
                ret.add(cur.val);
                cur = cur.right;
            }

        }

        for(int i=1;i< ret.size();i++) {
            if(ret.get(i)<=ret.get(i-1)) {
                return false;
            }
        }

        return true;

    }
}
