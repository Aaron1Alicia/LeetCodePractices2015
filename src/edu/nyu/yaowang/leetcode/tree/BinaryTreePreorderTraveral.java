package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yao on 1/8/15.
 * Recursion version is trivial: 198 ms
 * Preorder利用stack
 */
@SuppressWarnings("unused")
public class BinaryTreePreorderTraveral {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        preorderRecursion(root, ret);
        return ret;
    }

    public void preorderRecursion(TreeNode root, List<Integer> ret) {
        if(root==null) {
            return;
        }
        ret.add(root.val);
        preorderRecursion(root.left, ret);
        preorderRecursion(root.right, ret);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        // This stack is used to store those nodes that have lower priority
        // according to inorder traversal
        if(root==null) {
            return ret;
        }

        Stack<TreeNode> formerNodes = new Stack<TreeNode>();

        formerNodes.push(root);

        while(!formerNodes.isEmpty()) {
            TreeNode cur=formerNodes.pop();
            ret.add(cur.val);

            if(cur.right!=null) {
                formerNodes.push(cur.right);
            }

            if(cur.left!=null) {
                formerNodes.push(cur.left);
            }
        }

        return ret;
    }
}
