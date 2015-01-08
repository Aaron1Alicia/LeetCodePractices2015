package edu.nyu.yaowang.leetcode.miscellaneous;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/7/15.
 * 207 ms
 * 注意leaf node的处理，也就是node的左右两个节点都是null的情况
 */

@SuppressWarnings("unused")
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {

        if(root==null) {
            return 0;
        } else {
            return sumValue(root, 0);
        }
    }


    private int sumValue(TreeNode root, int prev) {
        int sum = prev*10 + root.val;
        int sumLeft = 0;
        int sumRight = 0;

        if(root.left!=null) {
            sumLeft = sumValue(root.left, sum);
        }

        if(root.right!=null) {
            sumRight = sumValue(root.right, sum);
        }

        if(sumLeft==0 && sumRight==0) {
            return sum;
        } else {
            return sumLeft+sumRight;
        }

    }
}
