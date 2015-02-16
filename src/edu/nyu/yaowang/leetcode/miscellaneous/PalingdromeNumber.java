package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/31/15.
 */
public class PalingdromeNumber {
    public boolean isPalindrome(int x) {
        long reverse = 0;
        long num = Math.abs(x);

        while(num>0) {
            reverse*=10;
            reverse+=num%10;
            num/=10;
        }

        return reverse==x;

    }
}
