package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/30/15.
 */
public class FindMinInRotatedArrayTwo {
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                //这里不是减1， 因为本身也可能是解
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }
}
