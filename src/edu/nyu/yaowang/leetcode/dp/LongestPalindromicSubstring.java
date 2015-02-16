package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 2/13/15.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int n = s.length();
        int maxLength = 1;
        int left = 0;
        int right = 0;

        boolean[][] dp = new boolean[n][n];


        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {

                if(s.charAt(i)==s.charAt(j)) {
                    if(i-j<2 || dp[j+1][i-1]) {
                        dp[j][i] = true;

                        if(i-j+1> maxLength) {
                            left = j;
                            right = i;
                            maxLength = i-j+1;
                        }
                    }

                }

            }

            dp[i][i] = true;

        }

        return s.substring(left, right+1);

    }
}
