package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yao on 1/21/15.
 */
@SuppressWarnings("unused")
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }

        if(root.left==null && root.right==null) {
            return 1;
        } else {

            int leftDepth = Integer.MAX_VALUE;
            int rightDepth = Integer.MAX_VALUE;

            if(root.left!=null) {
                leftDepth = minDepth(root.left);
            }

            if(root.right!=null) {
                rightDepth = minDepth(root.right);
            }

            return Math.min(leftDepth, rightDepth) +1;

        }

    }


    /*
      BFS方法可以得到iterative的解
     */
    public int minDepthIterative(TreeNode root) {
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

            if(cur.left==null && cur.right==null) {
                return level+1;
            }

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
