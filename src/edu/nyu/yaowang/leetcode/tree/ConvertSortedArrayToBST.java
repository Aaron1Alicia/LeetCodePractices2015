package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/21/15.
 */

@SuppressWarnings("unused")
 public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0) {
            return null;
        }

        int start = 0;
        int end = num.length-1;
        return sortedArray(num, 0, end);

    }

    private TreeNode sortedArray(int[] num, int start, int end) {

        if(start==end) {
            return new TreeNode(num[start]);
        } else if(start>end) {
            return null;
        } else {
            int mid = (start+end)/2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = sortedArray(num, start, mid-1);
            root.right = sortedArray(num, mid+1, end);
            return root;
        }

    }
}
