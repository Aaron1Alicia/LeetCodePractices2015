package edu.nyu.yaowang.leetcode.dp;

import java.util.Stack;

/**
 * Created by Yao on 1/26/15.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();
        int left = -1;

        for(int i =0; i<s.length();i++) {
            if(s.charAt(i)=='(') {
                st.push(i);
            } else {
                /*
                * 当遇到')'的时候，如果stack里没有剩余的'('了，就表示这是新的valid括号对的
                * 起点，这是这题的一个关键思路。以前可能会有一些valid的括号对。但是在这里，进入了
                * 新的计长阶段
                 */
                if(st.isEmpty()) {
                    left = i;
                } else {
                    st.pop();
                    if(st.isEmpty()) {
                        //可以确保从上个起点到当前index, 完全配好对了，是valid的
                        max = Math.max(max, i-left);
                    } else {
                        //可以确保上个没配好对的左括号一直到当前的index是这一阶段的长度
                        max = Math.max(max, i- st.peek());

                    }
                }
            }
        }

        return max;
    }

    public static void main(String [ ] args)
    {
        String s = ")()())";
        //String s = ")()";
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses(s));
    }

}
