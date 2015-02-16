package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Yao on 2/5/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root==null) {
            return ret;
        }

        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next;
        cur.add(root);


        while(!cur.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            next = new LinkedList<TreeNode>();
            while (!cur.isEmpty()) {
                TreeNode tmp = cur.poll();
                level.add(tmp.val);

                if(tmp.left!=null) {
                    next.add(tmp.left);
                }

                if(tmp.right!=null) {
                    next.add(tmp.right);
                }
            }

            cur = next;
        }

        return ret;

    }
}
