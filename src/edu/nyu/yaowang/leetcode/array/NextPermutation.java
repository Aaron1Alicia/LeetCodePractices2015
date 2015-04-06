package edu.nyu.yaowang.leetcode.array;

import java.util.Arrays;

/**
 * Created by Yao on 2/11/15.
 */
@SuppressWarnings("unused")
public class NextPermutation {

    public void nextPermutation(int[] num) {

        int n = num.length;
        int left = -1;

        for(int i=n-2; i>=0; i--) {

            if(num[i]<num[i+1]) {
                left = i;
                break;
            }

        }

        if(left != -1) {
            Arrays.sort(num, left+1, n);
            for(int i=left+1; i<n;i++) {

                if(num[i]>num[left]) {
                    swap(num, i, left);
                    break;
                }

            }

        } else {
            Arrays.sort(num, 0, n);
        }

    }

    private void swap(int[] num, int i, int j) {

        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;

    }

}
