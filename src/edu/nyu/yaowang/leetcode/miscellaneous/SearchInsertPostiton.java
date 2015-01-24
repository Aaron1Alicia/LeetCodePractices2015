package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/7/15.
 */
@SuppressWarnings("unused")
public class SearchInsertPostiton {
    public int searchInsert(int[] A, int target) {
        for(int i=0;i<A.length;i ++) {
            if(target<=A[i]) {
                return i;
            }
        }

        return A.length;
    }
}
