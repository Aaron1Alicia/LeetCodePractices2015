package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.Arrays;

/**
 * Created by Yao on 1/18/15.
 */
public class MajorityElement {
    // nlog(n)
    public int majorityElementBySorting(int[] num) {
        Arrays.sort(num);
        return num[num.length / 2];
    }

    //Get each bit of the number, than combine them, O(n) and in-place
    public int majorityElementByBitOperation(int[] num) {

        int ret = 0;

        for(int i=0;i<32;i++) {
            int ones=0;
            int zeroes=0;
            for(int j=0;j<num.length;j++) {

                if(((num[j])&(1<<i))==0) {
                    zeroes++;
                }else {
                    ones++;
                }

            }

            if(ones>zeroes){
                ret |= (1<<i);
            }

        }

        return ret;
    }

    //Moor Voting alogrithm, in-place, O(n)
    public int majorityElementByMoorVoting(int[] num) {
        int ret = 0;
        int count=0;

        for(int e:num) {
            ret = count==0?e:ret;
            if(ret==e) {
                count++;
            }else {
                count--;
            }


        }
        return ret;
    }

}
