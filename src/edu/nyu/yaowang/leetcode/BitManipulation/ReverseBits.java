package edu.nyu.yaowang.leetcode.BitManipulation;

/**
 * Created by Yao on 4/23/15.
 * 优化算法是查表, 这题很有意思
 * 普通算法就一位一位的做就行了
 */
@SuppressWarnings("unused")
public class ReverseBits {
    public int reverseBits(int n) {
        int[] tb = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int ret = 0;
        int mask = 15;

        for(int i=0; i<8; i++) {
            int tmp = (n>>i*4) & mask;
            ret |= tb[tmp]<<(28-i*4);
        }

        return ret;
    }
}
