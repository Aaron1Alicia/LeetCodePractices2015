package edu.nyu.yaowang.leetcode.ood;

import java.util.Stack;

/**
 * Created by Yao on 2/6/15.
 * 加上另一个stack, 用空间换时间
 */
public class MinStack {
    private Stack<Integer> elements = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public Integer push(int x) {

        elements.push(x);

        if(min.isEmpty() || x<=min.peek()) {
            min.push(x);
        }

        return x;

    }

    public Integer pop() {

        int tmp = elements.pop();
        if(tmp<=min.peek()) {

            min.pop();
        }

        return tmp;
    }

    public int top() {
        return elements.peek();

    }

    public int getMin() {
        return min.peek();
    }
}
