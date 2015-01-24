package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/22/15.
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int length = A.length;
        int[] ret = {-1, -1};
        int start = 0;
        int end = length-1;
        int mid = 0;
        int index = 0;

        while(start <= end) {
            mid = (start+end)/2;
            if(A[mid]==target) {
                index = mid;
                break;
            } else if(A[mid]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        //没有找到target, 那么就return {-1, -1};
        if(A[mid]!=target) {
            return ret;
        }

        start = mid;
        end = mid;

        //要点是check start>=0这个条件
        while(start>=0 && A[start]==target) {
            start--;
        }

        ret[0] = start+1;

        //同上，要先check end<=length-1
        while(end<=length-1 && A[end]==target) {
            end++;
        }

        ret[1] = end-1;

        return ret;

    }



    public static void main(String [ ] args)
    {
        SearchForARange test = new SearchForARange();

        int[] A = {5,7,7,8,8,10};

        int [] ret = test.searchRange(A, 8);

        for(int index: ret) {
            System.out.println(index);
        }

    }
}
