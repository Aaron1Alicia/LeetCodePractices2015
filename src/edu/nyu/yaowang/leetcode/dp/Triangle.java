package edu.nyu.yaowang.leetcode.dp;

import java.util.List;

/**
 * Created by Yao on 1/23/15.
 * 这题的要点是从下往上扫描, 不过对于横行应当是从左往右
 */
@SuppressWarnings("unused")
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

        //从下往上，从左往右，这样最简单，如果从右往左，从上往下就需要保存一下中间值，
        //否则原始值会被覆盖。
        for(int i=length-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                int cur = triangle.get(i).get(j);
                dp[j] = Math.min(dp[j], dp[j+1])+cur;
            }

        }

        return dp[0];

    }
}
