package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/19/15.
 * The minimum element must satisfy one of two conditions: 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0].
 * Therefore, we can use binary search: check the middle element,
 * if it is less than previous one, then it is minimum.
 * If not, there are 2 conditions as well: If it is greater than both left and right element, then minimum element should be on its right,
 * otherwise on its left.
 */
@SuppressWarnings("unused")
public class FindMinInRotatedArray {
    public int findMin(int[] num) throws Exception{

        int low =0;
        int high = num.length-1;


        while(low<high) {
            int mid = (low+high)/2;
            if(mid>0&&num[mid]<num[mid-1]) {
                return num[mid];
            }

            //mid要同时大于两边，才在右边。这是这题的解题要点
            if(num[low]<=num[mid] && num[mid]>num[high]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return num[low];


    }
}
