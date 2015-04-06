package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 2/4/15.
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder ) {

        if(preorder==null || inorder==null || preorder.length!=inorder.length || preorder.length==0) {
            return null;
        }

        int n = inorder.length;
        return buildTree(inorder, 0, n-1, preorder, 0, n-1);

    }

    private TreeNode buildTree(int[] inorder, int starti, int endi,
                               int[] preorder, int startp, int endp) {

        //这个条件很重要，因为tree有可能不是complete tree
        if(starti>endi) {
            return null;
        }

        if(starti==endi) {
            return new TreeNode(inorder[starti]);
        }

        int rootValue = preorder[startp];
        TreeNode root = new TreeNode(rootValue);
        int index = find(inorder, rootValue, starti);
        int length = index-starti;
        root.left = buildTree(inorder,starti, index-1, preorder, startp+1, startp+length);
        root.right = buildTree(inorder,index+1, endi, preorder, startp+length+1, endp);
        return root;

    }

    private int find(int[] array, int value, int start) {
        for (int i = start; i < array.length; i++)
            if (array[i] == value)
                return i;

        return -1;
    }
}
