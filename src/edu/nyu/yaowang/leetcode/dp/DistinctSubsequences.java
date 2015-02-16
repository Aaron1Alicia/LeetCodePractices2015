package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/26/15.
 * 典型的string和DP的结合题，注意base base的定义。网上有更简单的方法，不过我没看懂
 */
public class DistinctSubsequences {
        public int numDistinct(String S, String T) {
            int m = T.length();
            int n = S.length();

            int[][] dp = new int[m+1][n+1];

            if(m==0){
                return 1;
            }
            if(n<m) {
                return 0;
            }

            for(int i=1; i<=n; i++) {
                dp[1][i]=count(T.charAt(0),S.substring(0,i));
            }

            for(int i=1; i<=m; i++) {
                if(T.substring(0,i).equals(S.substring(0,i))) {
                    dp[i][i] = 1;
                }
            }

            for(int i=2; i<=m; i++) {
                for(int j=i; j<=n; j++) {

                    if(S.charAt(j-1)==T.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }

                }
            }

            return dp[m][n];
        }

    private int count(char c, String s) {
        int count = 0;
        for(int i=0; i<s.length();i++) {
            if(s.charAt(i)==c) {
                count++;
            }
        }

        return count;
    }


}
