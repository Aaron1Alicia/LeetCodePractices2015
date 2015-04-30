package edu.nyu.yaowang.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/31/15.
 * 这一题的思路是四个方向一层一层的剥，每剥一层更新一下值
 * 不要按照旋转的方法解，那样会比较复杂
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0) {
            return ret;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {

            for (int i = left; i <= right; i++) {
                ret.add(matrix[top][i]);
            }

            if (++top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                ret.add(matrix[i][right]);
            }

            if (--right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                ret.add(matrix[bottom][i]);
            }

            if (--bottom < top) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                ret.add(matrix[i][left]);
            }

            if (++left > right) {
                break;
            }

        }

        return ret;

    }
}
