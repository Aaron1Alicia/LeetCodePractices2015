package edu.nyu.yaowang.leetcode.math;

/**
 * Created by Yao on 2/5/15.
 * 二分法
 */
public class Power {
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            System.out.println(n);
            n = -n;
            System.out.println(n);
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);

    }

    public double pow(double x, long n) {
        if(n == 0)
            return 1;
        if(n<0){
            //这里有整型溢出的问题, 把参数换成long型就可以解决掉这个问题
            return pow(1/x, -n);
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);

    }

    public static void main(String[] args) {

        Power power = new Power();
        System.out.println(power.pow(1,-2147483648));

    }

}
