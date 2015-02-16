package edu.nyu.yaowang.leetcode.dfs;

/**
 * Created by Yao on 2/14/15.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) {
            return false;
        }

        int n = board.length;

        boolean[][] mark = new boolean[n][];
        //因为题目要求同一个
        for(int i=0; i<n; i++) {
            mark[i] = new boolean[board[i].length];
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(dfs(board, word, i, j, 0, mark)) {
                    return true;
                }

            }
        }


        return false;

    }

    private boolean dfs(char[][] board, String word, int row, int column,
                        int offset, boolean[][] mark) {

        if(offset==word.length()) {
            return true;
        }
        //注意这里的先后顺序的问题，先判断完row之后，才能开始判断column, 否则会有index的问题
        else if(row==board.length ||
                row<0 || column<0 || column == board[row].length ) {
            return false;
        }
        //这里其实是一个剪枝
        else if(mark[row][column]) {
            return false;
        }
        else if(word.charAt(offset)!=board[row][column]) {
            return false;
        } else {
            mark[row][column] = true;

            boolean ret = dfs(board, word, row+1, column, offset+1, mark) ||
                    dfs(board, word, row-1, column, offset+1, mark) ||
                    dfs(board, word, row, column+1, offset+1, mark) ||
                    dfs(board, word, row, column-1, offset+1, mark);

            mark[row][column] = false;
            return ret;

        }

    }
}
