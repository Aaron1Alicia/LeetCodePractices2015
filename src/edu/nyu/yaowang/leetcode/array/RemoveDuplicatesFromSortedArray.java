package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/17/15.
 * 有一个index来记录non-duplicate的位置
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        else if (A.length == 1)
            return 1;
        else {
            int ret = 1;
            int p = 0;
            for (int p1 = 1; p1 < A.length; p1++) {
                if (A[p1 - 1] != A[p1]) {
                    ret++;
                    A[++p] = A[p1];
                }
            }
            return ret;
        }
    }
}
