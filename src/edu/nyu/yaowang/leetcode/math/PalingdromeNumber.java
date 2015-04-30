package edu.nyu.yaowang.leetcode.math;

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


    public boolean isPalindrome2(int x) {
        if (x < 0) return false;

        int p = x;
        int q = 0;

        //这里10以下就不继续比较了是为了解决溢出问题
        while (p >= 10){
            q *=10;
            q += p%10;
            p /=10;
        }

        //实际上只用比较一半长度就行了,所以少比较一位其实不影响.
        return q == x / 10 ;

    }
}
