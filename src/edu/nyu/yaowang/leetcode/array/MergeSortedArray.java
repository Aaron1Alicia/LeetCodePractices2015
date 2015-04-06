package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/7/15.
 * insert number from right to left
 * notice two details:
 * 1. when longer array elements exhausted before shorter array
 * 2. only minus index when fetch element from that array
 */
@SuppressWarnings("unused")
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i>=0&&j>=0) {

            // shift i or j only when use that number
            A[k] = A[i]>B[j]?A[i--]:B[j--];
            k--;
        }

        while(j>=0) {
            A[k--] = B[j--];
        }

    }
}
