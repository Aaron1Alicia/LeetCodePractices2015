package edu.nyu.yaowang.leetcode.math;

/**
 * Created by Yao on 1/31/15.
 * http://www.cnblogs.com/shadowmydx/p/4235053.html
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n > 1)
        {
            n/=5;
            result += n;

        }
        return result;
    }
}
