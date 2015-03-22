package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yao on 1/18/15.
 * 经典recursion解法，存储父节点
 */
@SuppressWarnings("unused")
public class PopulatingNextRightPointersInEachNodeOneAndTwo {

    public void connectByRecursion(TreeLinkNode root) {
        if(root==null) {
            return;
        }

        if(root.left!=null && root.right!=null) {
            root.left.next = root.right;
            if(root.next!=null) {
                root.right.next = root.next.left;
            }
            connectByRecursion(root.left);
            connectByRecursion(root.right);
        }

    }

    public void connectByInterative(TreeLinkNode root) {
        while(root!=null) {
            TreeLinkNode temp = new TreeLinkNode(-1);
            TreeLinkNode cur = temp;
            while(root!=null) {
                if(root.left!=null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right!=null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = temp.next;

        }

    }

    // BFS algorithm, 利用size来完成里层循环
    public void connectByBFS(TreeLinkNode root) {
        if(root==null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

        queue.add(root);

        while(queue.size()>0) {
            //Queue<TreeLinkNode> back = new LinkedList<TreeLinkNode>();
            int n = queue.size();
            for(int i=0; i<n; i++) {
                TreeLinkNode cur = queue.poll();
                if(i==n-1) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }

                if(cur.left!=null) {
                    queue.add(cur.left);
                }
                if(cur.right!=null) {
                    queue.add(cur.right);
                }
            }


        }
    }
}
