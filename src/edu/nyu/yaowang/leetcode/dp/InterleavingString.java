package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/25/15.
 * http://blog.csdn.net/u011095253/article/details/9248073
 * 这题可以再优化内存占用，将二维dp改为一维dp
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if((n1+n2)!=n3) {
            return false;
        }

        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;

        for(int i=1; i<=n1; i++) {
            dp[i][0]= s1.substring(0, i).equals(s3.substring(0, i)) ;
        }

        for(int i=1; i<=n2; i++) {
            dp[0][i]= s2.substring(0, i).equals(s3.substring(0, i)) ;
        }

        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                dp[i][j] |= dp[i-1][j] && (s1.charAt(i-1)== s3.charAt(i+j-1));
                dp[i][j] |= dp[i][j-1] && (s2.charAt(j-1)== s3.charAt(i+j-1));
            }
        }

        return dp[n1][n2];

    }

}
