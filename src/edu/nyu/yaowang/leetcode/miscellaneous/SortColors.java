package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/21/15.
 */
public class SortColors {
    public void sortColors(int[] A) {

        if(A==null || A.length<=1) {
            return;
        }

        int n = A.length;
        int left = -1;
        int right = n;
        int index = 0;

        while(index < right) {

            if(A[index] == 0) {
                swap(A, left+1, index);
                //这里要加index, 因为swap回来的要么是0要么是1，不加的话会导致left
                //超过index, 那样会有逻辑错误
                index++;
                left++;
                continue;
            } else if(A[index]==2) {
                swap(A, index, right-1);
                right--;
                continue;
            } else {
                index++;
            }
        }

    }


    private void swap(int[] A, int left, int right) {

        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;

    }

    public static void main(String [] args)
    {
        int[] A = {0,0,0,1,0};
        //int[] A = {1,2,0};
        //int[] A = {0};
        //int[] A = {2, 0};

        SortColors color = new SortColors();
        color.sortColors(A);
        for (int i:A) {

            System.out.println(i);
        }
    }
}
