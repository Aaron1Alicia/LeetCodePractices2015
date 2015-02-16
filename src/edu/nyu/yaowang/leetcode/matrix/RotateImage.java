package edu.nyu.yaowang.leetcode.matrix;

/**
 * Created by Yao on 1/30/15.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for(int i=0;i<n;i++) {
            for(int j=0; j<n-i-1;j++) {

                swap(matrix, i, j, n-j-1, n-i-1);
            }
        }

        for( int i =0; i<n/2; i++) {
            for(int j=0;j<n;j++) {
                swap(matrix, i, j, n-i-1 ,j);
            }
        }

    }


    private void swap(int[][] matrix, int i, int j, int n, int k) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n][k];
        matrix[n][k] = tmp;

    }
}
