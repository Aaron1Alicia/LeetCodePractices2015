package edu.nyu.yaowang.leetcode.matrix;

/**
 * Created by Yao on 1/30/15.
 * bound四个边的极值，这一题很有意思。
 * 这一题可以用等号是因为肯定是正方形，最后肯定会
 * 转化为left=right and top=down这种情况
 * 而相关联的另外一道因为是长方形，所以需要处理
 * 特殊情况,详见source code
 */
public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int k=1;

        while(left<=right && top<= bottom) {
            for(int i=left; i<=right; i++) {
                matrix[top][i] = k++;
            }
            for(int i=top+1; i<=bottom; i++) {
                matrix[i][right] = k++;
            }
            for(int i=right-1; i>=left; i--) {
                matrix[bottom][i] = k++;
            }
            for(int i=bottom-1; i>=top+1; i--) {
                matrix[i][left] = k++;
            }

            left++;
            right--;
            top++;
            bottom--;

        }

        return matrix;


    }

}
