package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.*;

/**
 * Created by Yao on 2/6/15.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> ret = new HashMap<String, List<String>>();


        for(int i=0; i<strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String temp = new String(tmp);

            if(!ret.containsKey(temp)) {
                ret.put(temp, new ArrayList<String>());
            }

            ret.get(temp).add(strs[i]);
        }

        List<String> result = new ArrayList<String>();
        for (String key : ret.keySet()) {
            List<String> temp = ret.get(key);
            if(temp.size()>1) {
                result.addAll(temp);
            }

        }

        return result;
    }

}
