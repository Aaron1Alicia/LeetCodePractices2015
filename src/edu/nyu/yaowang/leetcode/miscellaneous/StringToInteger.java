package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/15/15.
 */
public class StringToInteger {
    public int atoi(String str) {

        for(int i=0; i< str.length(); i++) {
            if(str.charAt(i)!=' ') {
                str = str.substring(i);
                break;
            }
        }

        int n = str.length();
        if(n==0) {
            return 0;
        }

        boolean isNegative = false;

        if(str.charAt(0) == '-' || str.charAt(0) == '+') {
            if(str.charAt(0) == '-') {
                isNegative = true;
            }
            str = str.substring(1);
        }

        //注意这个要声明成double型
        double ret = 0;

        for(int i = 0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp>= '0' && tmp <= '9') {
                ret = (int)(tmp-'0') + ret*10;
            } else {
                break;
            }

        }

        if(isNegative) {
            ret = -ret;
            if(ret<=Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        if(ret> Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)ret;

    }


    public static void main(String[] args) {

        String test = "9223372036854775809";
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.atoi(test));

    }
}
