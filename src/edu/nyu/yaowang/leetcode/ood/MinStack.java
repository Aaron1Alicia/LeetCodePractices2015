package edu.nyu.yaowang.leetcode.ood;

import java.util.Stack;

/**
 * Created by Yao on 2/6/15.
 * 加上另一个stack, 用空间换时间
 */
@SuppressWarnings("unused")
public class MinStack {
    private Stack<Integer> st = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        st.push(x);
        if(minStack.size()==0 || x<=getMin()) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer tmp = st.pop();
        if(tmp!=null && tmp==getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
