package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 2/15/15.
 * 这一题是一道比较典型的DP问题
 */
public class BestTimeToBuyAndSellStockThree {
    public int maxProfit(int[] prices) {


        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        // find best
        int[] left = new int[n];
        int[] right = new int[n];

        int min = prices[0];
        for(int i= 1; i<n; i++) {
            int cur = prices[i] - min;
            left[i] = Math.max(cur, left[i-1]);
            min = Math.min(min, prices[i]);
        }

        int max = prices[n-1];
        for(int i= n-2; i>=0; i--) {
            int cur = max - prices[i];
            right[i] = Math.max(cur, right[i+1]);
            max = Math.max(prices[i], max);
        }

        max = 0 ;
        for(int i=0; i< n; i++) {
            max = Math.max(left[i]+right[i], max);
        }

        return max;


    }
}
