package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/21/15.
 * 这题的要点是要不停的更新前面最小值的index
 */
@SuppressWarnings("unused")
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;

        for(int i=1;i<prices.length;i++) {
            int profit = prices[i] - prices[left];
            if(profit>maxProfit){
                maxProfit=profit;
            }

            if(prices[i]<prices[left]) {
                left = i;
            }
        }

        return maxProfit;
    }
}
