package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yao on 2/10/15.
 */
public class WordBreakTwo {
    public List<String> wordBreak(String s, Set<String> dict) {

        List<String> ret = new ArrayList<String>();
        if(s==null || s.length()==0) {
            return ret;
        }
        String tmp = "";

        boolean[] possible = getPossible(s, dict);
        if(possible[0]) {
            dfs(s, tmp, ret, dict, 0, possible);
        }

        if(possible[0]) {
            System.out.println("true");
         } else {
            System.out.println("false");
        }


        return ret;
    }

    private void dfs(String s, String tmp, List<String> ret,
                     Set<String> dict, int start, boolean[] possible) {
        if(start==s.length()) {
            ret.add(tmp.substring(0, tmp.length()-1));
            System.out.println("here?");

        } else {

            for(int i=start+1; i<=s.length(); i++) {
                //注意这里是个剪枝
                if(possible[i] && dict.contains(s.substring(start,i))) {
                    dfs(s, tmp+s.substring(start,i)+" ", ret, dict, i, possible);
                }

            }

        }

    }


    public boolean[] getPossible(String s, Set<String> dict) {

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

        return dp;

    }

    public static void main(String[] args) {

        WordBreakTwo word = new WordBreakTwo();
        Set<String> set = new HashSet<String>();
        set.add("a");
        String s = "a";
        List<String> ret = word.wordBreak(s, set);
        System.out.println(ret);
    }





}
