package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 2/4/15.
 * Recursive方法
 */
public class ConstructBinaryTreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null) {
            return null;
        }

        if(inorder.length==0) {
            return null;
        }

        if(inorder.length!=postorder.length) {
            return null;
        }

        int n = inorder.length;
        return buildTree(inorder, 0, n-1, postorder, 0, n-1);

    }

    private TreeNode buildTree(int[] inorder, int starti, int endi,
                               int[] postorder, int startp, int endp) {

        if(starti>endi) {
            return null;
        }
        if(starti==endi) {
            return new TreeNode(inorder[starti]);
        }

        int rootValue = postorder[endp];
        TreeNode root = new TreeNode(rootValue);
        int index = find(inorder, rootValue, starti);
        int length = index-starti;
        root.left = buildTree(inorder,starti, index-1, postorder, startp, startp+length-1);
        root.right = buildTree(inorder,index+1, endi, postorder, startp+length, endp-1);
        return root;

    }

    private int find(int[] array, int value, int start) {
        for (int i = start; i < array.length; i++)
            if (array[i] == value)
                return i;

        return -1;
    }

}
