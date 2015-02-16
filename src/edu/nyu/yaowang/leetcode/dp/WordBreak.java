package edu.nyu.yaowang.leetcode.dp;

import java.util.Set;

/**
 * Created by Yao on 2/6/15.
 * 这一题的思路和palindrome partition two非常相似
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] =  true;

        for(int i=n-1; i>=0;i--) {

            for(int j=i+1;j<=n;j++) {

                if(dict.contains(s.substring(i,j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }

            }

        }

        return dp[0];

    }
}
