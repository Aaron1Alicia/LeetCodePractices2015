package edu.nyu.yaowang.leetcode.stack;

/**
 * Created by Yao on 1/27/15.
 * 对每一个index, 求取左边的最大值和右边的最大值。这是这题的一个关键思路
 */
public class TrappingRainWater {
    public int trap(int[] A) {

        int n = A.length;
        if(n<=2) {
            return 0;
        }
        boolean flag = false;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int max=A[0];

        //Find the left maximum for each index
        for(int i=1; i<n;i++) {
            leftMax[i] = max;
            max = Math.max(max, A[i]);
        }

        max = A[n-1];

        for(int i=n-2; i>=0; i--) {
            rightMax[i] = max;
            max = Math.max(max, A[i]);
        }

        int sum = 0;
        for( int i=1;i<n-1;i++) {
            int high = Math.min(leftMax[i], rightMax[i]);
            int tmp = high-A[i];
            sum+= tmp>0?tmp:0;
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater test = new TrappingRainWater();

        System.out.println(test.trap(A));

    }
}
