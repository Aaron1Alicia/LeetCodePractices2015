package edu.nyu.yaowang.leetcode.miscellaneous;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidParenthesesTest {

    private ValidParentheses test;

    @Before
    public void setUp() throws Exception {
        test = new ValidParentheses();
    }

    @Test
    public void testIsTrue() throws Exception {

        String s = "{}[]()";
        assertTrue(test.isValid(s));
        s = "{][]()";
        assertFalse(test.isValid(s));

    }
}