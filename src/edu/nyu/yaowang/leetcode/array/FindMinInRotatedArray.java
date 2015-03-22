package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/19/15.
 * 为了防止没有乱序这种特殊情况，用mid和end比较
 */
@SuppressWarnings("unused")
public class FindMinInRotatedArray {
    public int findMin(int[] num) throws Exception{

        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else {
                //不要-1
                hi = mid;
            }
        }
        return num[lo];


    }
}
