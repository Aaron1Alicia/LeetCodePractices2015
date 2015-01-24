package edu.nyu.yaowang.leetcode.miscellaneous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPostitonTest {

    private SearchInsertPostiton testSearchInsertPostiton;

    @Before
    public void setUp() throws Exception {
        testSearchInsertPostiton = new SearchInsertPostiton();

    }

    @Test
    public void testSearchInsert() throws Exception {

        int[] A = {1,3,5,6};

        assertEquals(2, testSearchInsertPostiton.searchInsert(A,5));



    }
}