package edu.nyu.yaowang.leetcode.math;

/**
 * Created by Yao on 2/5/15.
 * 注意溢出问题，所以要采用long型。
 * 然后以mid为基准进行范围选取
 */
public class Sqrt {
    public int sqrt(int x) {

        long start = 0;
        long end = x/2+1;
        long mid=0;

        while(true) {
            mid=(start+end)/2;
            if(mid*mid<=x && (mid+1)*(mid+1)>x) {
                return new Long(mid).intValue();
            }

            if(mid*mid>x) {
                end = mid-1;
            } else {
                start = mid+1;
            }

        }


    }
}
