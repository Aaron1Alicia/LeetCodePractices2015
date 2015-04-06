package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/22/15.
 */
@SuppressWarnings("unused")
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        /*
        这个函数不能处理 num.length-1等于0的情况，因此要单独提出这个条件。
        另外如果num==null 或者num.length==0的话，那么这个函数就没有意义了。
        可以throw Exception...
         */
        if(num.length==1) {
            return 0;
        }

        int start = 0;
        int end = num.length-1;

        int mid = 0;

        while(true) {
            mid = (start+end)/2;
            if((mid==num.length-1 && num[mid]>num[mid-1]) || (mid==0 && num[mid]>num[mid+1])
                    || ((mid!=0 && mid!=num.length-1) && num[mid]>num[mid-1]  && num[mid]>num[mid+1])  ) {
                return mid;
            } else if(num[mid]<num[mid+1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }

}
