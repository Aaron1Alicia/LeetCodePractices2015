package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/14/15.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0) {
            return Integer.MAX_VALUE;
        }

        //这里必须要声明成long型
        long did = dividend;
        long div = divisor;

        boolean sign = ((double)did * (double)div)>= 0? true: false;

        did = did>0? did:-did;
        div = div>0? div: -div;

        if(did<div) {
            return 0;
        }

        int step = 0;
        long tmp = div;
        while(div<did) {
            div = div<<1;
            step++;
        }


        long ret = 0;

        while(did>=tmp) {
            if(did>=div) {
                did-=div;
                //这里必须是1l,否则有可能会溢出
                ret +=1l<<step;
            }
            div = div>>1;
            step--;
        }

        if(!sign) {
            if(ret> Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int)-ret;
            }

        } else {
            if(ret> Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)ret;
            }

        }

    }


    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers =
                new DivideTwoIntegers();

        System.out.println(divideTwoIntegers.divide(
                Integer.MIN_VALUE, -1
        ));

    }
}
