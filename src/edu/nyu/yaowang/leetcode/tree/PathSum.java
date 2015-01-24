package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/22/15.
 * 注意sum可以是负的
 */
@SuppressWarnings("unused")
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Leetcode认为只要root==null, 不论sum等于多少都是false.
        // 这个其实倒不是很重要，具体到时候跟面试官确认就行了
        if(root==null) {
            return false;
        }

        boolean left = false;
        boolean right = false;

        //Base case
        if(root.left==null && root.right==null) {
            if(sum==root.val) {
                return true;
            } else {
                return false;
            }

        } else{

            if(root.left!=null) {
                left = hasPathSum(root.left, sum-root.val);
            }
            if(root.right!=null) {
                right = hasPathSum(root.right, sum-root.val);
            }

            return left || right;
        }

    }
}
