package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 2/6/15.
 * 分成正负两种情况考虑，也可以合在一起考虑
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int min = A[0];
        int max = A[0];
        int ret = A[0];


        for(int i=1; i<n; i++) {

            if(A[i]>=0) {
                max = Math.max(max*A[i], A[i]);
                min = Math.min(min*A[i], A[i]);
                ret = Math.max(max, ret);
            } else {

                int tmp = max;
                max = Math.max(min*A[i], A[i]);
//                System.out.println("max="+max);
                min = Math.min(tmp*A[i], A[i]);
//                System.out.println("min="+min);
                ret = Math.max(max, ret);
//                System.out.println("ret="+ret);
            }

        }

        return new Long(ret).intValue();
    }



    public static void main(String[] args) {

        int[] A = {-4, -3, -2};
        MaximumProductSubarray productSubarray = new
                MaximumProductSubarray();

        System.out.println(productSubarray.maxProduct(A));

    }
}
