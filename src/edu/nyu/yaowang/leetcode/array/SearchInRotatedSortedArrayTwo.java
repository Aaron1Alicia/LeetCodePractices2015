package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/30/15.
 * 这一题tricky的地方在于A[mid]==A[start]的时候无法判断是递增还是递减
 * 方法就是相等的时候skip掉这个元素，重新二分查找
 * http://zhangxc.com/2013/12/leetcod-search-in-rotated-sorted-array-2
 *
 */
public class SearchInRotatedSortedArrayTwo {
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length-1;

        while(start<=end) {
            int mid = (start+end)/2;
            if(A[mid]==target) {
                return true;
            } else if(A[mid]>A[end]) {

                if(target>=A[start] && target < A[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }

            } else if(A[mid]<A[end]){

                if(target>A[mid] && target <= A[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }

            } else {
                end--;
            }
        }

        return false;
    }
}
