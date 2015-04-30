package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Yao on 1/7/15.
 * 170ms
 * 主要是stack这个数据结构
 */
@SuppressWarnings("unused")
public class ValidParentheses {
    public boolean isValid(String s) {

        if(s==null || s.length()==0) {
            return true;
        }

        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        HashSet<Character> set = new HashSet<Character>();
        set.add('(');
        set.add('[');
        set.add('{');

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                st.push(c);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                Character last = st.pop();
                if(!last.equals(map.get(c))) {
                    return false;
                }
            }
        }

        if(st.size()>0) {
            return false;
        }

        return true;
    }
}
