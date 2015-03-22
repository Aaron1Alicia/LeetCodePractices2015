package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.*;

/**
 * Created by Yao on 1/17/15.
 * 255ms
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root==null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();


        queue.add(root);
        int count = 1;

        while(queue.size()>0) {
            List<Integer> tmp = new ArrayList<Integer>();
            int n = count;
            count=0;

            for(int i=0; i<n; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);

                if(cur.left!=null) {
                    queue.add(cur.left);
                    count++;
                }
                if(cur.right!=null) {
                    queue.add(cur.right);
                    count++;
                }
            }
            ret.add(tmp);


        }

        return ret;
    }
}
