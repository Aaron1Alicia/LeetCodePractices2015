package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yao on 1/8/15.
 * Recursion version: 196ms
 * Postorder的iterative的方法和preorder的iterative的方法相似，不过是先压左边，再压右边。
 * 最后对整个结果要逆序。
 *
 */
@SuppressWarnings("unused")
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        postorderRecursion(root, ret);
        return ret;
    }

    public void postorderRecursion(TreeNode root, List<Integer> ret) {
        if(root==null) {
            return;
        }
        postorderRecursion(root.left, ret);
        postorderRecursion(root.right, ret);
        ret.add(root.val);
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
            TreeNode cur = formerNodes.pop();
            ret.add(cur.val);

            if(cur.left!=null) {
                formerNodes.push(cur.left);
            }

            if(cur.right!=null) {
                formerNodes.push(cur.right);
            }
        }

        Collections.reverse(ret);

        return ret;
    }
}
