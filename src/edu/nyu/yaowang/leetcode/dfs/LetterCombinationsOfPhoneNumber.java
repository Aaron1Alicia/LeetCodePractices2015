package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        char[][] table = {{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> ret = new ArrayList<String>();
        dfs(digits,"", table, ret);
        return ret;
    }

    private void dfs(String digits, String tmp, char[][]table, List<String> ret) {
        if(digits.length()==0) {
            ret.add(tmp);
        } else {
            for(int i=0;i<table[digits.charAt(0)-'0'-1].length; i++) {
                dfs(digits.substring(1), tmp+table[digits.charAt(0)-'0'-1][i], table, ret);
            }
        }
    }
}
