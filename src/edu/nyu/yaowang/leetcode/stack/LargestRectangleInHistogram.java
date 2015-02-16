package edu.nyu.yaowang.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Yao on 1/27/15.
 * 这其实是一个DP解法，在index i处，计算出以i终止（不包括i）的最大值，然后keep moving. Stack里存储的是比当前index
 * 处值大的index的集合
 *
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {

        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        //int[] h = new int[height.length + 1];
        int[] h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                //注意在没有移到比stack里元素都大之前，i不增加
            }
        }
        return maxArea;

    }
}
