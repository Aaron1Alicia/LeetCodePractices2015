package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/18/15.
 */
public class UniquePathsOneAndTwo {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            dp[i][0] = 1;
        }

        for(int j=0;j<n;j++) {
            dp[0][j] = 1;
        }


        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
               dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsTwo(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==0){
            dp[0][0] =1;
        }else {
            dp[0][0] =0;
        }

        for(int i=1;i<m;i++) {
            dp[i][0]= obstacleGrid[i][0]==1?0:dp[i-1][0];
        }

        for(int j=1;j<n;j++) {
            dp[0][j] = obstacleGrid[0][j]==1?0:dp[0][j-1];
        }


        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
                if(obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
