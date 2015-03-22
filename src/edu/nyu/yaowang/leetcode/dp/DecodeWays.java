package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/26/15.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        // Input validation
        if(s==null || s.length()==0) {
            return 0;
        }

        // Special case and branch pruing
        String head = s.substring(0,1);
        if(!isValid(head)) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            String tmp = s.substring(i-1, i);
            if(isValid(tmp)) {
                dp[i] += dp[i-1];
            }
            tmp = s.substring(i-2, i);
            if(isValid(tmp)) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }


    private boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return false;
        } else {
            int value = Integer.parseInt(s);
            return value>=1 && value<=26;
        }
    }

    public static void main(String[] args) {
        String s = "123";
        DecodeWays test = new DecodeWays();

        System.out.println(test.numDecodings(s));
    }



}
