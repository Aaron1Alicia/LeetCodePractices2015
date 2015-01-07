package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/6/15.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int ret=0;
        for(int i=0;i<A.length;i++) {
            ret^=A[i];
        }
        return ret;
    }
}
