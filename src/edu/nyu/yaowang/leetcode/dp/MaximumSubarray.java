package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/26/15.
 * dp[k]定义为以index k截止的最大sum的子序列
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        int max = A[0];
        dp[0] = A[0];

        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1]+A[i], A[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
