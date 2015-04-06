package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 2/14/15.
 * 值有可能是负的，所以不一定要到叶子节点，而且题意也说任意一条path
 */
@SuppressWarnings("unused")
public class BinaryTreeMaximumPathSum {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxValue;

    }
    public int maxPath(TreeNode root) {
        if(root==null) {
            return 0;
        } else {
            int leftMax = Math.max(0, maxPath(root.left));
            int rightMax = Math.max(0, maxPath(root.right));
            maxValue = Math.max(maxValue, leftMax+rightMax+root.val);
            return Math.max(leftMax, rightMax)+root.val;

        }

    }


    public int maxPathSumNoClassMember(TreeNode root) {

        if(root==null) {
            return 0;
        }

        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(Integer.MIN_VALUE);
        maxPath(root, tmp);
        return (int)tmp.get(0);

    }


    /*
    用ArrayList的方法可以walk around需要保存class data member的问题
     */
    private int maxPath(TreeNode root, List<Integer> tmp) {

        if(root==null) {
            return 0;
        }  else {

            //这个与0比较然后取大的值很关键，用来解决有负值的问题
            int left = Math.max(0, maxPath(root.left, tmp));
            int right = Math.max(0, maxPath(root.right, tmp));

            int cur =left + right + root.val;
            if(cur> tmp.get(0)) {
                tmp.set(0, cur);
            }

            return Math.max(left, right) + root.val;
        }
    }


}
