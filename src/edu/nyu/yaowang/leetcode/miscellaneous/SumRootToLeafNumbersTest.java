package edu.nyu.yaowang.leetcode.miscellaneous;

import edu.nyu.yaowang.leetcode.TreeGenerator;
import edu.nyu.yaowang.leetcode.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumRootToLeafNumbersTest {

    private SumRootToLeafNumbers testSumRootToLeafNumbers;
    @Before
    public void setUp() throws Exception {
        testSumRootToLeafNumbers = new SumRootToLeafNumbers();
    }


    @Test
    public void testSumNumbers() throws Exception {
        int[] treeArray = {1, 2,3, -99, -99};
        TreeNode testTree = TreeGenerator.generate(treeArray);
        assertEquals(25, testSumRootToLeafNumbers.sumNumbers(testTree));
    }
}