package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yao on 1/6/15.
 */
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        else {
            int left =  maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

    /*
      用BFS方法可以iterative的解决这个问题
     */
    public int maxDepthIterative(TreeNode root) {
        if(root==null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int lastNum = 1;
        int curNum = 0;
        int level = 0;


        while(!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            lastNum--;

            if(cur.left!=null) {
                queue.add(cur.left);
                curNum++;
            }

            if(cur.right!=null) {
                queue.add(cur.right);
                curNum++;
            }

            if(lastNum==0) {
                lastNum = curNum;
                curNum = 0;
                level++;
            }

        }

        return level;
    }
}
