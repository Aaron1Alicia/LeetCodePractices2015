package edu.nyu.yaowang.leetcode.BitManipulation;

/**
 * Created by Yao on 4/4/15.
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {

        int count = 0;
        for(int i=0; i<32; i++) {

            //注意这里要用不等于0，不能用大于0，因为1有可能在最高位
            //这样就变成一个负数
            if(((1<<i) & n) !=0) {
                count++;
            }

        }

        return count;

    }
}
