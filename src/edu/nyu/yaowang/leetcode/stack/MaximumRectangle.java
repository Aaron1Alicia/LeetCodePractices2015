package edu.nyu.yaowang.leetcode.stack;

import java.util.Stack;

/**
 * Created by Yao on 1/27/15.
 * 这题其实是将二维矩阵投影到一维上，然后用largest histgram的方法解
 */
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int[] h = new int[m+1];
        int max = 0;

        for(int i=0;i<n;i++) {
            Stack<Integer> st = new Stack<Integer>();
            //注意这里+1
            for( int j=0; j<m+1;j++) {
                //注意这里要限定范围
                if(j<m) {
                    if(matrix[i][j]=='1') {
                        h[j]+=1;
                    } else {
                        h[j] = 0;
                    }
                }

                if(st.empty() || h[j]>h[st.peek()]) {
                    st.push(j);
                } else {
                    while(!st.empty() && h[j]<=h[st.peek()]) {
                        int tmp = st.pop();
                        max = Math.max(max, h[tmp]*(st.empty()? j: j-st.peek()-1));
                    }
                    //这一句不要忘
                    st.push(j);
                }

            }
        }


        return max;

    }
}
