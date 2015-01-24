package edu.nyu.yaowang.leetcode.dp;

import java.util.List;

/**
 * Created by Yao on 1/23/15.
 * 这题的要点是从下往上扫描, 不过对于横行应当是从左往右
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int length = triangle.size();
        if(length<1) {
            return 0;
        }
        int[] dp = new int[length];

        for(int i=0;i<length;i++) {
            dp[i] = triangle.get(length-1).get(i);
        }


        for(int i=length-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                int cur = triangle.get(i).get(j);
                dp[j] = Math.min(dp[j], dp[j+1])+cur;
            }

        }
        return dp[0];

    }
}
