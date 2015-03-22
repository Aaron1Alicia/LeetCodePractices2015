package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/19/15.
 * 先判定哪一边有序，然后判断是否在有序的那边的范围里，如果在，就在有序的范围内二分查找，如果不在,
 * 就在另一部分二分查找。注意base case，就是中间的值.
 * 为了防止没有乱序这种特殊情况，应当用mid和end比较
 */
@SuppressWarnings("unused")
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length-1;

        while(start<=end) {
            int mid = (start+end)/2;
            if(A[mid]==target) {
                return mid;
            } else if(A[mid]>A[end]) {

                if(target>=A[start] && target < A[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }

            } else {

                if(target>A[mid] && target <= A[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }

            }
        }

        return -1;

    }
}
