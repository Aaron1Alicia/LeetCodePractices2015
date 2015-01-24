package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/23/15.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstColumn = false;

        int m = matrix.length;
        if(m==0) {
            return;
        }

        int n = matrix[0].length;

        for(int i=0; i<m; i++) {
            if(matrix[i][0]==0) {
                firstColumn = true;
            }
            //这一题的要点是不能加上这一行，否则会丢失原来的信息。
            //matrix[i][0] = 0;
        }

        for(int i=0; i<n; i++) {
            if(matrix[0][i]==0) {
                firstRow = true;
            }
            //matrix[0][i] = 0;
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][j]==0) {
                    //如果本来就为0， 也不影响结果
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }
        }

        for(int i=1;i<m;i++) {
            if(matrix[i][0]==0) {
                for(int j=0; j<n; j++) {
                    matrix[i][j] =0;
                }
            }

        }

        for(int i=1;i<n;i++) {
            if(matrix[0][i]==0) {
                for(int j=0; j<m; j++) {
                    matrix[j][i] =0;
                }
            }
        }

        if(firstRow) {
            for(int i=0;i<n;i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstColumn) {
            for(int i=0;i<m;i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
