package edu.nyu.yaowang.leetcode.dfs;

import java.util.Arrays;

/**
 * Created by Yao on 2/16/15.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return false;
        }

        if(s1.equals(s2)) {
            return true;
        }

        //这里的sort其实算是剪枝
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        int n = s1.length();

        for(int i=0; i<n; i++) {
            if(char1[i]!=char2[i]) {
                return false;
            }
        }

        for(int i=1; i<n; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if(isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }

            s21 = s2.substring(0, n-i);
            s22 = s2.substring(n-i);

            if(isScramble(s11, s22) && isScramble(s12, s21)) {
                return true;
            }


        }

        return false;


    }
}
