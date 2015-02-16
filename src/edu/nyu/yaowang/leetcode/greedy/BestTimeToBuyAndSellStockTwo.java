package edu.nyu.yaowang.leetcode.greedy;

/**
 * Created by Yao on 1/27/15.
 * 很无聊的一道题，关键是了解一下greedy的原理
 */
public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0){
            return 0;
        }
        int n = prices.length;
        int previous = prices[0];
        int sum = 0;

        for(int i=1;i<n;i++) {

            if(prices[i]>previous) {
                sum+=prices[i]- previous;
            }
            previous = prices[i];
        }

        return sum;
    }
}
