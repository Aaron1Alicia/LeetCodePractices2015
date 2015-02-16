package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 2/14/15.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int n = A.length;

        if(A==null || n==0) {
            return 1;
        }


        for(int i=0; i<n;) {
            //注意这里没有i++, 因为如果不满足要求就继续swap
            if((A[i]>0) && (A[i]<=n) && (A[i]!=i+1) && (A[i]!=A[A[i]-1])) {
                int tmp = A[i];
                A[i] = A[A[i]-1];
                A[tmp-1] = tmp;
            } else {
                i++;
            }

        }

        for(int i=0; i<n; i++) {
            if(A[i]!=i+1) {
                return i+1;
            }
        }

        return n+1;

    }


    public static void main(String[] args) {
        int[] test = {2,1};
        FirstMissingPositive first =
                new FirstMissingPositive();

        System.out.println(first.firstMissingPositive(test));

    }
}
