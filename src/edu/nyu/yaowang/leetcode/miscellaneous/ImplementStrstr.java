package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/6/15.
 * Sunday算法
 * http://blog.csdn.net/v_july_v/article/details/7041827
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {

        int start = 0;
        int n = needle.length();
        int m = haystack.length();

        while(m-start>=n) {

            String tmp = haystack.substring(start);
            if(isMatch(tmp, needle)) {
                return start;
            } else {
                int next = start+n;
                if(next>=m) {
                    break;
                }

                int offset = -1;

                for(int i=n-1;i>=0;i--) {

                    if(needle.charAt(i)==haystack.charAt(next)) {
                        offset=(n-i);
                        break;
                    }

                }

                if(offset==-1) {
                    start+=n;
                } else {
                    start+=offset;
                }

            }

        }


        return -1;

    }




    private boolean isMatch(String haystack, String needle) {

        if(haystack.length()< needle.length()) {
            return false;
        }

        int n = needle.length();

        for(int i=0; i<n; i++) {
            if(haystack.charAt(i)!=needle.charAt(i) ){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String haystack = "aaa";
        String needle = "a";

        ImplementStrstr implementStrstr = new
                ImplementStrstr();

        System.out.println(implementStrstr.strStr(haystack,needle));
    }
}
