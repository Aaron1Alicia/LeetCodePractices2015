package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeGenerator;
import edu.nyu.yaowang.leetcode.TreeNode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SameTreeTest {
    private SameTree testSameTree;

    @Before
    public void setUp() throws Exception {
        testSameTree = new SameTree();
    }

    @Test
    public void testIsSameTreeIsTrue() throws Exception {
        int[] treeArray = {1, 2,3,-99,4,-99,5,6,7};
        TreeNode p = TreeGenerator.generate(treeArray);
        TreeNode q = TreeGenerator.generate(treeArray);

        assertTrue(testSameTree.isSameTree(p, q));

    }

    @Test
    public void testIsSameTreeIsFalse() throws Exception {
        int[] treeArrayOne = {1, 2,3,-99,4,-99,5,6,7};
        int[] treeArrayTwo = {1, 2,4,-99,4,-99,5,6,7};
        TreeNode p = TreeGenerator.generate(treeArrayOne);
        TreeNode q = TreeGenerator.generate(treeArrayTwo);

        assertFalse(testSameTree.isSameTree(p, q));

    }
}