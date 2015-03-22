package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.*;

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

    // Reverse解法
    public List<Integer> preorderTraversalIterativeOne(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        // This stack is used to store those nodes that have lower priority
        // according to inorder traversal
        if(root==null) {
            return ret;
        }

        Stack<TreeNode> formerNodes = new Stack<TreeNode>();
        formerNodes.push(root);

        while(!formerNodes.isEmpty()) {
            TreeNode cur = formerNodes.pop();
            ret.addFirst(cur.val);

            if(cur.left!=null) {
                formerNodes.push(cur.left);
            }

            if(cur.right!=null) {
                formerNodes.push(cur.right);
            }
        }

        return ret;
    }

    //常规解法
    public List<Integer> preorderTraversalIterativeTwo(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode lastVisited = null;

        while(!st.isEmpty() || root!=null) {
            if(root!=null) {
                st.push(root);
                root = root.left;
            } else {
                TreeNode peek = st.peek();

                if(peek.right!=null && peek.right!=lastVisited) {
                    root = peek.right;
                } else {
                    st.pop();
                    res.add(peek.val);
                    lastVisited = peek;
                }
            }
        }
        return res;
    }



}
