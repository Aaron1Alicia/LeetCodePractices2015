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

        if(root.left!=null) {
            connectLeft(root.left, root);
        }

        if(root.right!=null) {
            connectRight(root.right, root);
        }


    }

    public void connectLeft(TreeLinkNode node, TreeLinkNode parent) {
        node.next = parent.right;
        if(node.left!=null) {
            connectLeft(node.left, node);
        }

        if(node.right!=null) {
            connectRight(node.right, node);
        }
    }

    public void connectRight(TreeLinkNode node, TreeLinkNode parent) {
        if(parent.next!=null) {
            node.next = parent.next.left;
        }

        if(node.left!=null) {
            connectLeft(node.left, node);
        }

        if(node.right!=null) {
            connectRight(node.right, node);
        }

    }

    // BFS algorithm, 利用size来完成里层循环
    public void connectByBFS(TreeLinkNode root) {
        if(root==null) {
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();


            // size来完成里层循环，或者采用两个queue
            while(size>0) {
                TreeLinkNode tmp = q.poll();
                size--;
                //如果只使用一个queue,这个判断很重要, 如果使用两个queue, 那么就没有这个判断
                if(size>0) {
                    tmp.next = q.peek();
                }

                if(tmp.left!=null) {
                    q.add(tmp.left);
                }

                if(tmp.right!=null) {
                    q.add(tmp.right);
                }
            }

        }
    }
}
