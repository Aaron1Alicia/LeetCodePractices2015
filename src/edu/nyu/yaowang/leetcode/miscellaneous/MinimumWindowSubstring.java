package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yao on 2/19/15.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++) {
            map.put(T.charAt(i), 0);
        }

        Boolean isFull = false;
        int n = map.size();

        for(int i=0; i<T.length(); i++) {
            if(map.containsKey(T.charAt(i))) {
                

            }
        }


    }
}
