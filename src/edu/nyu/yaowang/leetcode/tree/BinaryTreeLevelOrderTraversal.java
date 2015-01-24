package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.*;

/**
 * Created by Yao on 1/17/15.
 * 255ms
 * BFS算法，使用两个arrayList, 将下一层的Node加入到下一层的队列中
 * 2与1的差别
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next;

        cur.add(root);

        while(!cur.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            next = new LinkedList<TreeNode>();
            while(!cur.isEmpty()) {
                TreeNode tmp = cur.poll();
                level.add(tmp.val);
                if(tmp.left!=null) {
                    next.add(tmp.left);
                }
                if(tmp.right!=null) {
                    next.add(tmp.right);
                }
            }
            ret.add(level);
            cur = next;
        }

        Collections.reverse(ret);
        return ret;

    }
}
