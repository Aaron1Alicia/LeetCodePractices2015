package edu.nyu.yaowang.leetcode.BitManipulation;

/**
 * Created by Yao on 1/21/15.
 */
@SuppressWarnings("unused")
public class SingleNumberTwo {
    public int singleNumber(int[] A) {
        int ret = 0;
        for(int i=0;i<32;i++) {
            int count = 0;
            for(int j=0;j<A.length;j++) {
                count+= (A[j]>>i) & 1;
            }
            ret |= ((count%3)<<i);
        }

        return ret;
    }
}
