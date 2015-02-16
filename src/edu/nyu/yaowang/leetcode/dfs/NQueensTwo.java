package edu.nyu.yaowang.leetcode.dfs;

/**
 * Created by Yao on 1/30/15.
 */
@SuppressWarnings("unused")
public class NQueensTwo {
    private int ret=0;

    public int totalNQueens(int n) {

        if(n<=0) {
            return ret;
        }

        int[] columnNumberForLine = new int[n];
        dfs(columnNumberForLine, 0);

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


    private void dfs(int[] columnNumberForLine, int curLineNumber) {

        int n = columnNumberForLine.length;
        if(curLineNumber==n) {
            ret+=1;
        } else {
            for(int i=0; i<n; i++) {
                columnNumberForLine[curLineNumber] = i;
                if(isValid(columnNumberForLine, curLineNumber)) {
                    dfs(columnNumberForLine, curLineNumber+1);
                }

            }

        }

    }
}
