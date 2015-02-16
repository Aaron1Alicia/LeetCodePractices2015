package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/26/15.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n==0) return 0;
        int[] dp = new int[n+1];
        //放这个safe guard很妙
        dp[0] = 1;
        if (isValid(s.substring(0,1))) dp[1] = 1;
        else dp[1] = 0;
        for(int i=2; i<=n;i++){
            if (isValid(s.substring(i-1,i)))
                dp[i] = dp[i-1];
            if (isValid(s.substring(i-2,i)))
                dp[i] += dp[i-2];
        }
        return dp[n];
    }

    public boolean isValid(String s){
        //这里也是个关键点
        if (s.charAt(0)=='0') return false;
        int code = Integer.parseInt(s);
        return code>=1 && code<=26;
    }

    public static void main(String[] args) {
        String s = "123";
        DecodeWays test = new DecodeWays();

        System.out.println(test.numDecodings(s));
    }



}
