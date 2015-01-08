package edu.nyu.yaowang.leetcode;

/*  this handy tool help you to generate a tree using an int array as input.
    for example, your input is: {1,2,3,-99,4,-99,5,6,7}
    (-99 is a "reserved" number used to cap the leaf. you can modify this number if you need to)
    will generate the tree :
             1
            / \
           2   3
            \   \
             4   5
            / \
           6   7

*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class TreeGenerator {

    public static TreeNode generate(int[] a) {
        TreeNode root = new TreeNode(a[0]);
        TreeNode temp1 = null;
        TreeNode temp2 = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        for (int i = 1; i < a.length; ++i) {
            temp2 = new TreeNode(a[i]);
            if (q.element().left!=null && q.element().right!=null)
                q.remove();
            temp1 = q.element();
            if (temp1.left == null)
                temp1.left = temp2;
            else if (temp1.right==null)
                temp1.right = temp2;
            if (a[i] != -99)
                q.add(temp2);
        }
        deleteCaps(root);
        return root;
    }

    private static void deleteCaps (TreeNode root){
        if (root.left!=null){
            if (root.left.val==-99) root.left=null;
            else deleteCaps(root.left);
        }
        if (root.right!=null){
            if (root.right.val==-99) root.right=null;
            else deleteCaps(root.right);
        }
    }



}
