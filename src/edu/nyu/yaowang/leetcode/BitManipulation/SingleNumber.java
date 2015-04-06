package edu.nyu.yaowang.leetcode.BitManipulation;

/**
 * Created by Yao on 1/6/15.
 */
public class SingleNumber {
    @SuppressWarnings("unused")
    public int singleNumber(int[] A) {
        int ret=0;
        for(int i=0;i<A.length;i++) {
            ret^=A[i];
        }
        return ret;
    }

    public static void main(String [] args){
        int a=-132142;
        int ret=0;
        ret=a^a;

        System.out.println(a);
        System.out.println(ret);
    }
}
