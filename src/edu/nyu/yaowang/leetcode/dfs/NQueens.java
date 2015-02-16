package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/29/15.
 * 一行一行的放，注意要验证对角线
 * http://blog.csdn.net/u011095253/article/details/9158473
 *
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {

        List<String[]> ret = new ArrayList<String[]>();
        if(n<=0) {
            return ret;
        }

        int[] columnNumberForLine = new int[n];
        dfs(columnNumberForLine, 0, ret);

        return ret;
    }


    private boolean isValid(int[] columnNumberForLine, int curLineNumber) {

        for(int i=0;i<curLineNumber;i++) {
            if(columnNumberForLine[i]==columnNumberForLine[curLineNumber]
                    || (curLineNumber-i)==Math.abs(columnNumberForLine[i]-columnNumberForLine[curLineNumber])) {
                return false;
            }

        }

        return true;

    }


    private void dfs(int[] columnNumberForLine, int curLineNumber, List<String[]> ret) {

        int n = columnNumberForLine.length;
        if(curLineNumber==n) {
            printBoard(columnNumberForLine, ret);

        } else {
            for(int i=0; i<n; i++) {
                columnNumberForLine[curLineNumber] = i;
                if(isValid(columnNumberForLine, curLineNumber)) {
                    dfs(columnNumberForLine, curLineNumber+1, ret);
                }

            }

        }

    }


    private void printBoard(int[] columnNumberForLine, List<String[]> ret) {
        int n = columnNumberForLine.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            sb.setCharAt(columnNumberForLine[i], 'Q');
            result[i] = sb.toString();
        }

        ret.add(result);

    }

}
