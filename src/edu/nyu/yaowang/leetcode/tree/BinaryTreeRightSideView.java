package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Yao on 4/20/15.
 */
@SuppressWarnings("unused")
public class BinaryTreeRightSideView {
    public List<Integer> rightSideViewBFS(TreeNode root) {

        List<Integer> ret = new LinkedList<Integer>();
        if(root==null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int numberOfNodesThisLevel = 1;
        int numberOfNodesInNextLevel = 0;

        while(!queue.isEmpty()) {

            TreeNode tmp = queue.poll();

            numberOfNodesThisLevel--;


            if(tmp.left!=null) {
                queue.add(tmp.left);
                numberOfNodesInNextLevel++;
            }

            if(tmp.right!=null) {
                queue.add(tmp.right);
                numberOfNodesInNextLevel++;
            }

            if(numberOfNodesThisLevel==0) {
                ret.add(tmp.val);
                numberOfNodesThisLevel = numberOfNodesInNextLevel;
                numberOfNodesInNextLevel = 0;
            }

        }

        return ret;

    }


    /*
    Recursion方法,每次都是深入下一层在第一个非null节点上加入这个节点的值
    要点是先遍历右子树,再遍历左子树
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ret = new LinkedList<Integer>();
        dfs(root, ret, 1);

        return ret;
    }

    public void dfs(TreeNode root, List<Integer> ret, int depth) {
        if(root==null) {
            return;
        }

        if(depth > ret.size()) {
            ret.add(root.val);
        }

        dfs(root.right, ret, depth+1);
        dfs(root.left, ret, depth+1);

    }
}
