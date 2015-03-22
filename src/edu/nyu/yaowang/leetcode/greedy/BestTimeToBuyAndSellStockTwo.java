package edu.nyu.yaowang.leetcode.greedy;

/**
 * Created by Yao on 1/27/15.
 * 很无聊的一道题，关键是了解一下greedy的原理
 */
public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {

        int ret = 0;
        if(prices==null || prices.length==0) {
            return ret;
        }

        int n = prices.length;

        for(int i=1; i<n; i++) {
            if(prices[i]>prices[i-1]) {
                ret+=(prices[i]-prices[i-1]);
            }

        }
        return ret;
    }
}
