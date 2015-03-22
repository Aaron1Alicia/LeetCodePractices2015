package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/17/15.
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) {
            return 0;
        }
        int pre = A[0] -1;

        int n = A.length;
        //记录non-duplicate的位置
        int j = -1;

        for(int i=0; i<n; i++) {
            if(A[i] != pre) {
                A[++j] = A[i];
                pre = A[i];
            }

        }

        return j+1;
    }
}
