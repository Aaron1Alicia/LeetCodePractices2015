package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/29/15.
 * 这一题的要点是右节点始终是leaf节点，所以只用考虑左节点即可。
 * 然后就是标准的DFS，base case+recursion
 */
public class BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root==null) {
            return null;
        }

        if(root.left==null && root.right==null) {
            return root;
        }

        TreeNode tmp = root.left;
        TreeNode newRoot = UpsideDownBinaryTree(root.left);
        tmp.left = root.right;
        tmp.right = root;
        root.left = null;
        root.right = null;
        return newRoot;

    }

}
