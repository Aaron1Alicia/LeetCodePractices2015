package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/25/15.
 * http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
 * 加上绿色blommberg笔记本上对递推公式的说明！！！非常重要！！！
 */
public class PalindromePartitionTwo {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        //d[n]相当于safe guard, 注意要减1
        //这是dp的初始化，这是与其他dp稍稍区别的地方
        for(int i=0; i<=n; i++) {
            dp[i]=n-i-1;
        }
        boolean[][] isPal = new boolean[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {

                //只需要考虑palindrome的情况
                if(s.charAt(i)==s.charAt(j) && ((j-i<2) || isPal[i+1][j-1] )) {
                    isPal[i][j] = true;
                    dp[i]=Math.min(dp[i], dp[j+1]+1);
                }

            }
        }

        return dp[0];

    }
}
