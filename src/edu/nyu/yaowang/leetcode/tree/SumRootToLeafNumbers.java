package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/7/15.
 * 207 ms
 * 注意leaf node的定义，也就是node的左右两个节点都是null的情况
 * 另外，从这一题可以看出DFS每个节点其实只过一遍，所以直接DFS也可以
 */

@SuppressWarnings("unused")
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root, int sum)
    {
        if(root == null)
            return 0;
        if(root.left==null && root.right==null)
            return sum*10+root.val;
        return dfs(root.left,sum*10+root.val)+dfs(root.right,sum*10+root.val);
    }
}
