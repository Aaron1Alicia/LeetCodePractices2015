package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeGenerator;
import edu.nyu.yaowang.leetcode.TreeNode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MaximumDepthBinaryTreeTest {
    private MaximumDepthBinaryTree testMaximumDepthBinaryTree;

    @Before
    public void setUp() throws Exception {
        testMaximumDepthBinaryTree = new MaximumDepthBinaryTree();

    }

    @Test
    public void testMaxDepth() throws Exception {
        int[] treeArray = {1, 2,3,-99,4,-99,5,6,7};
        TreeNode testTree = TreeGenerator.generate(treeArray);
        assertEquals(4,testMaximumDepthBinaryTree.maxDepth(testTree));

    }
}