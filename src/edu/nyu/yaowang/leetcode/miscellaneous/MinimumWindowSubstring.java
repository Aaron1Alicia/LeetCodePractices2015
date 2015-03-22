package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yao on 2/19/15.
 * http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {

        Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>();


        for(int i=0; i<T.length(); i++) {
            char cur = T.charAt(i);
            if(needToFind.containsKey(cur)) {
                int tmp = needToFind.get(cur);
                needToFind.put(cur, tmp+1);
            } else {
                needToFind.put(cur,1);
                hasFound.put(cur, 0);
            }
        }

        int begin = 0;
        int count = 0;
        int miniBegin = 0;
        int miniEnd = 0;
        int miniLength = Integer.MAX_VALUE;

        for(int i=0; i<S.length(); i++) {
            char cur = S.charAt(i);
            if(!needToFind.containsKey(cur)) {
                continue;
            }

            if(hasFound.get(cur)<needToFind.get(cur)) {

                count++;
            }
            hasFound.put(cur, hasFound.get(cur)+1);

            if(count==T.length()) {
                while(!hasFound.containsKey(S.charAt(begin)) ||
                        hasFound.get(S.charAt(begin))>needToFind.get(S.charAt(begin))) {
                    if(hasFound.containsKey(S.charAt(begin))) {
                        int tmp = hasFound.get(S.charAt(begin));

                        hasFound.put(S.charAt(begin), tmp-1);
                    }

                    begin++;
                }

                if(i-begin+1<miniLength) {
                    miniBegin = begin;
                    miniEnd = i;
                    miniLength = miniEnd-miniBegin+1;
                }
            }



        }

        if(count!=T.length()) {
            return "";
        }
        return S.substring(miniBegin, miniEnd+1);
    }
}
