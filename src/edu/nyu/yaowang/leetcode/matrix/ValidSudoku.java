package edu.nyu.yaowang.leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yao on 2/4/15.
 * 这题是纯实现题，不过可以用bitMap优化一下空间和速度
 * 用set着实有点高端
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i =0; i<9; i++) {
           if(!isValid(board, 0, 8, i, i) ) {
               return false;
           }
            if(!isValid(board, i, i, 0, 8)) {
                return false;
            }
        }

        for(int i=0; i<=6;i++) {
           for(int j=0;j<=6;j++) {
               if(!isValid(board,i,i+2,j,j+2)) {
                   return false;
               }

           }
        }

        return true;
    }


    private boolean isValid(char[][] board, int x1, int x2, int y1, int y2) {
        Set<Character> set = new HashSet<Character>();

        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
               if(!set.add(board[i][j])) {
                   return false;
                }
            }
        }

        return true;

    }
}
