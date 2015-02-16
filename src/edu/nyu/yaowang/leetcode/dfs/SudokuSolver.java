package edu.nyu.yaowang.leetcode.dfs;

/**
 * Created by Yao on 2/15/15.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        isSolvable(board);
    }

    public boolean isSolvable(char[][] board) {

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {

                if(board[i][j]=='.') {
                    for(int k=1; k<=9; k++) {
                        char tmp = (char)('0'+k);

                        if(isValidNum(board, i, j, tmp) ) {
                            board[i][j] = tmp;
                            if(isSolvable(board)){
                                return true;
                            }
                            board[i][j] = '.';

                        }



                    }
                    return false;

                }

            }
        }

        return true;
    }

    public boolean isValidNum(char[][] board, int row, int col, char m){
        for(int k = 0; k < 9; k++){
            //test if it is valid in its row, column, and box.
            if(board[row][k] == m || board[k][col] == m || board[(row/3)*3+k%3][(col/3)*3+k/3] == m)
                return false;
        }
        return true;
    }
}
