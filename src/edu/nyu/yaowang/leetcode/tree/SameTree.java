package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/6/15.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null){
            if(q==null) {
                return true;
            }
            else {
                return false;
            }
        }

        if(q==null) {
            return false;
        } else {
            if(p.val!=q.val) {
                return false;
            } else if(!isSameTree(p.left,q.left)) {
                return false;
            } else if(!isSameTree(p.right, q.right)) {
                return false;
            } else {
                return true;
            }

        }
    }
}
