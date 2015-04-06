package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/18/15.
 * 有没有obstacle影响两点：
 * 1. base case的初始化
 * 2. j=0的处理
 */
@SuppressWarnings("unused")
public class UniquePathsOneAndTwo {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }

        while(m>1) {
            //没有obstacle的时候，j=0时不用做处理，如果有obstacle, 需要单独处理
            for(int j=1; j<n; j++) {
                dp[j] += dp[j-1];
            }
            m--;
        }

        return dp[n-1];
    }

    public int uniquePathsTwo(int[][] obstacleGrid) {

        if(obstacleGrid==null || obstacleGrid.length==0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] ==1 ?0:1;
        for(int i=1; i<n; i++) {
            dp[i] = obstacleGrid[0][i] ==1? 0:dp[i-1];
        }

        int k = 1;

        while(k< m) {
            for(int j=0; j<n; j++) {
                if(j==0) {
                    if(obstacleGrid[k][j] == 1) {
                        dp[j] = 0;
                    }
                } else {
                    dp[j] = obstacleGrid[k][j] == 1? 0: dp[j]+dp[j-1];
                }
            }
            k++;
        }

        return dp[n-1];
    }
}
