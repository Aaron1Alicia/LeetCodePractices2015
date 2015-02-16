package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.HashMap;

/**
 * Created by Yao on 2/13/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0) {
            return 0;
        }

        int max = 1;

        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int lastIndex = 0;

        for(int i=0; i<n; i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                lastIndex = Math.max(map.get(c)+1, lastIndex);
            }
            map.put(c, i);
            max = Math.max(i-lastIndex+1,max);

        }

        return max;


    }
}
