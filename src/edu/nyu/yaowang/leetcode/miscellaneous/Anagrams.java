package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.*;

/**
 * Created by Yao on 2/6/15.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> ret = new ArrayList<String>();
        int n = strs.length;
        if(n<=1) {
            return ret;
        }

        String[] newStrs = new String[n];

        for(int i=0;i<n;i++) {
            newStrs[i] = sortString(strs[i]);
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Set<Integer> index = new HashSet<Integer>();


        for(int i=0;i<n;i++) {
            if( map.containsKey(newStrs[i])) {
                index.add(i);
                index.add(map.get(newStrs[i]));
            } else {
                map.put(newStrs[i], i);
            }
        }

        for (Integer i: index) {
            ret.add(strs[i]) ;
        }

        return ret;
    }

    private String sortString(String s) {
        char [] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
