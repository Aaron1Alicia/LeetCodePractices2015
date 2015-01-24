package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/23/15.
 * 在remove duplicates from sorted array的基础上，加上一个flag记录这是否是
 * 第一次出现的duplicates
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        else if (A.length == 1)
            return 1;
        else {
            int ret = 1;
            int p = 0;
            boolean flag = false;
            for (int p1 = 1; p1 < A.length; p1++) {
                if (A[p1 - 1] != A[p1]) {
                    ret++;
                    A[++p] = A[p1];
                    flag = false;
                } else if(A[p1-1]==A[p1] && flag == false) {
                    ret++;
                    A[++p] = A[p1];
                    flag = true;
                }
            }
            return ret;
        }

    }
}
