package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/21/15.
 * 这题的要点是要不停的更新前面最小值的index
 */
@SuppressWarnings("unused")
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }

        int maxProfit = 0;
        int min = prices[0];

        for(int i=1; i<prices.length; i++) {

            maxProfit = Math.max(prices[i]-min, maxProfit);
            min = Math.min(min, prices[i]);

        }

        return maxProfit;
    }
}
