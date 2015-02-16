package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/1/15.
 * O(n)算法，更新上限，如果到达某一点之后就无法前进了，那么
 * return false, 否则return true.
 * 这个算法是你自己想出来的哦！撒花！
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if( A.length==1) {
            return true;
        }
        int end = A[0];
        for(int i=1; i<=end; i++) {
            if(i+A[i]>end) {
                end = i+A[i];
            }

            if(end>=A.length-1) {
                return true;
            }

        }

        return false;

    }
}
