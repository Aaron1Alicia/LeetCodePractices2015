package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/22/15.
 * BST, 注意循环退出的条件和index的计算
 */
@SuppressWarnings("unused")
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int width = matrix[0].length;
        int low = 0;
        //这里已经减去1了，所以后面计算纵坐标的时候就不用-1了
        int high = width * length - 1;
        //如果用mid+1和mid-1的话，这里一般都是小于等于的
        while (low <= high) {
            int mid = (low + high) / 2;
            int x = mid / width;
            int y = mid % width;
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
