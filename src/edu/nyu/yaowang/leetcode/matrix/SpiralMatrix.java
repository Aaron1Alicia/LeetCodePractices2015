package edu.nyu.yaowang.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/31/15.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) {
            return ret;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
        int k=1;

        while(left<right && top< bottom) {
            for(int i=left; i<right; i++) {
                ret.add(matrix[top][i]);
            }
            for(int i=top; i<bottom; i++) {
                ret.add(matrix[i][right]);
            }
            for(int i=right; i>left; i--) {
                ret.add(matrix[bottom][i]);
            }
            for(int i=bottom; i>top; i--) {
                ret.add(matrix[i][left]);
            }

            left++;
            right--;
            top++;
            bottom--;

        }

        //只剩一列
        if(left==right && top<bottom) {
            for(int i=top; i<=bottom;i++) {
                ret.add(matrix[i][left]);
            }

        }
        //只剩一行
        if(top==bottom && left<right) {
            for(int i=left; i<=right;i++) {
                ret.add(matrix[top][i]);
            }

        }
        //只剩一个元素
        if(top==bottom && left==right) {
            ret.add(matrix[top][left]);
        }

        return ret;
    }
}
