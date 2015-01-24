package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.Stack;

/**
 * Created by Yao on 1/7/15.
 * 170ms
 * 主要是stack这个数据结构
 */
@SuppressWarnings("unused")
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        Character tmp = stack.pop();
                        if (!tmp.equals('(')) {
                            return false;
                        }
                    } else {
                        return false;
                    }

                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    if (!stack.isEmpty()) {
                        Character tmp = stack.pop();
                        if (!tmp.equals('{')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (!stack.isEmpty()) {
                        Character tmp = stack.pop();
                        if (!tmp.equals('[')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;

            }
            i++;
        }

        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
