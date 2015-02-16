package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/29/15.
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        if(s.length()<1) {
            return 0;
        }

        int sum = cToI(s.charAt(0));

        for(int i=1;i<s.length();i++) {
            if(cToI(s.charAt(i)) > cToI(s.charAt(i-1))) {
                sum+= (cToI(s.charAt(i)) - 2* cToI(s.charAt(i-1)));
            } else {
                sum += cToI(s.charAt(i));
            }

        }


        return sum;

    }

    private int cToI(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }

    }
}
