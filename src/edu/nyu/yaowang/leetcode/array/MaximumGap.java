package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 2/14/15.
 */
public class MaximumGap {
    public int maximumGap(int[] num) {
        int n = num.length;
        if(n<2) {
            return 0;
        }

        radixSort(num);

        int ret = -1;

        for(int i=1; i<n; i++) {
            ret = Math.max(ret, num[i]-num[i-1]);
        }

        return ret;

    }


    private void radixSort(int[] num) {
        int max = getMax(num);

        for(int i=1; max/i>0; i*=10) {
            countSort(num, i);
        }

    }


    private void countSort(int[] num , int bit) {

        int n = num.length;
        int[] count = new int[10];
        int[] output = new int[n];

        for(int i=0; i<n; i++) {
            count[(num[i]/bit)%10]++;
        }

        for(int i=1; i<10; i++) {
            count[i]+=count[i-1];
        }

        for(int i=n-1; i>=0; i--) {
            output[count[(num[i]/bit)%10]-1] = num[i];
            count[(num[i]/bit)%10]--;
        }

        for(int i=0; i<n; i++) {
            num[i] = output[i];
        }

    }


    private int getMax(int[] num) {
        int n = num.length;
        int ret = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            ret = Math.max(num[i], ret);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] test = {1, 10000000};

        MaximumGap gap = new MaximumGap();

        System.out.println(gap.maximumGap(test));

    }

}
