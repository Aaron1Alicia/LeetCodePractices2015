package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/1/15.
 * http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 */
public class JumpGameTwo {
    public int jump(int[] A) {
        int n = A.length;
        int currentBound =0;
        int lastBound = 0;
        int ret=0;

        for(int i=0; i<A.length;i++) {
            if(i>lastBound) {
                ret++;
                lastBound = currentBound;
            }

            currentBound = Math.max(A[i]+i, currentBound);

        }

        return ret;

    }

}
