package edu.nyu.yaowang.leetcode.array;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindMinInRotatedArrayTest {
    private FindMinInRotatedArray test;

    @Before
    public void setUp() throws Exception {
        test = new FindMinInRotatedArray();
    }

    @Test
    public void testFindMin() throws Exception {
        int[] input = {4,5,6,7,0,1,2};
        assertEquals(0,test.findMin(input));

    }

    @Test
    public void testFindMin2() throws Exception {
        int[] input = {1,2};
        assertEquals(1,test.findMin(input));

    }
}