package edu.nyu.yaowang.leetcode.matrix;

/**
 * Created by Yao on 1/30/15.
 * 剥洋葱,这一题和spiralmatrix one是同一种解法
 */
public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int tmp = 1;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;


        while(true) {
            for(int i=left; i<=right; i++) {
                ret[top][i] = tmp++;
            }

            if(++top>bottom) {
                break;
            }

            for(int i=top; i<=bottom; i++) {
                ret[i][right] = tmp++;
            }

            if(--right<left) {
                break;
            }

            for(int i=right; i>=left; i--) {
                ret[bottom][i] = tmp++;
            }

            if(--bottom<top) {
                break;
            }

            for(int i=bottom; i>=top; i--) {
                ret[i][left] = tmp++;
            }

            if(++left>right) {
                break;
            }
        }

        return ret;
    }

}
