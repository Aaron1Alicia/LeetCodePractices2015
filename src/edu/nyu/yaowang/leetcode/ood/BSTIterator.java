package edu.nyu.yaowang.leetcode.ood;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.*;

/**
 * Created by Yao on 1/31/15.
 */
public class BSTIterator {

    private List<Integer> mem;
    int cur = 0;
    public BSTIterator(TreeNode root) {
        mem = inorderTraversalRecursion(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(cur<mem.size()) {
            mem.get(cur);
            return true;
        }

        return false;

    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        inorderRecursion(root, ret);
        return ret;
    }

    public void inorderRecursion(TreeNode root, List<Integer> ret) {
        if(root==null) {
            return;
        }
        inorderRecursion(root.left, ret);
        ret.add(root.val);
        inorderRecursion(root.right, ret);
    }

    /** @return the next smallest number */
    public int next() {
        return mem.get(cur++);
    }
}
