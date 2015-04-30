package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/1/15.
 * O(n)算法，更新上限，如果到达某一点之后就无法前进了，那么
 * return false, 否则return true.
 */
@SuppressWarnings("unused")
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) {
            return false;
        }
        int rightMost = 0;
        int length = nums.length-1;
        int i = 0;
        while(i<=rightMost) {

            rightMost = Math.max(rightMost, nums[i]+i);
            if(rightMost>=length) {
                return true;
            }

            i++;
        }

        return false;

    }
}
