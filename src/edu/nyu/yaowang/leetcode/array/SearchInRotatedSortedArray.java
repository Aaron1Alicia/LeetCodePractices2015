package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/19/15.
 * 先判定哪一边有序，然后判断是否在有序的那边的范围里，如果在，就在有序的范围内二分查找，如果不在,
 * 就在另一部分二分查找。注意base case，就是中间的值
 */
@SuppressWarnings("unused")
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int low =0;
        int high = A.length-1;


        while(low<=high) {
            int mid = (low+high)/2;
            if(A[mid]==target) {
                return mid;
            }

            if(A[low]<A[mid]) {
                if(target>=A[low]&&target<A[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }

            } else {

                if(target>A[mid]&&target<A[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }


        return -1;

    }
}
