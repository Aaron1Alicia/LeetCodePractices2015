package edu.nyu.yaowang.leetcode.math;

/**
 * Created by Yao on 2/5/15.
 *
 */
@SuppressWarnings("unused")
public class Sqrt {
    //注意溢出问题，所以要采用long型。
    public int sqrt(int x) {

        long start = 0;
        //这个初始条件的选取要注意，不过对速度影响不大，不过是多了一次二分而已
        long end = x/2+1;

        while(true) {
            long mid = (start+end)/2;

            if(mid*mid<=x && (mid+1)*(mid+1)>x) {
                return (int)mid;
            } else if(mid*mid>x) {
                end = mid-1;
            } else {
                start = mid+1;
            }

        }

    }

    //用除法可以避免使用long型的问题, 不过需要多考虑0和1的情况以避免除数为0
    public int sqrtWithoutLong(int x) {

        if(x==0) return 0;
        if(x==1) return 1;
        int l=0;
        int r=x/2+1;
        while(true)
        {
            int m = (l+r)/2;
            if(m<=x/m && x/(m+1)<m+1)
                return m;
            if(x/m<m)
            {
                r = m-1;
            } else
            {
                l = m+1;
            }
        }


    }
}
