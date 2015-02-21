package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/13/15.
 * http://www.cnblogs.com/springfor/p/3861890.html
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int k = m + n;
        if (k % 2 != 0) {
            return findKth(A, 0, B, 0, k / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, k / 2) + findKth(A, 0, B, 0, k / 2 + 1)) / 2.0;
        }
    }

    private double findKth(int A[], int a, int B[], int b, int k) {
        if(A.length-a > B.length-b) {
            return findKth(B, b, A, a, k);
        } else if (a >= A.length) {
            return B[b + k - 1];
        }else if(k==1) {
            return Math.min(A[a], B[b]);
        }

        int partA = Math.min(k/2, A.length-a );
        int partB = k-partA;

        if(A[a+partA-1] < B[b+partB-1]) {
            return findKth(A, a+partA, B, b, k-partA);
        } else if(A[a+partA-1] > B[b+partB-1]) {
            return findKth(A, a, B, b+partB, k-partB);
        } else {
            return A[a+partA-1];
        }


    }


    public static void main(String[] args) {
       int[] A = {1};
        int[] B = {1};

        MedianOfTwoSortedArrays medianOfTwoSortedArrays =
                new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(A,B));
    }
}
