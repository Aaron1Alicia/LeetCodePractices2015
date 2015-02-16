package edu.nyu.yaowang.leetcode.dfs;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/23/15.
 * Typical DFS题目, base case+recursion
 */
public class UniqueBinarySearchTreesTwo {
    public List<TreeNode> generateTrees(int n) {
        return buildBST(1, n);
    }

    public List<TreeNode> buildBST(int start, int end) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(start>end) {
            ret.add(null);
            return ret;
        } else {
            for(int i=start;i<=end;i++) {
                List<TreeNode> leftTrees = buildBST(start, i-1);
                List<TreeNode> rightTrees = buildBST(i+1, end);
                for(TreeNode left: leftTrees) {
                    for(TreeNode right: rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ret.add(root);
                    }
                }
            }
        }
        return ret;

    }
}
