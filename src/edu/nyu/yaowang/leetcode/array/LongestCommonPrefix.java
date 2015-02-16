package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 2/1/15.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if(strs==null || strs.length==0) {
            return prefix.toString();
        }

        for(int i=0; i<strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++) {
                //注意这里有个边界条件的检查
                if(i>=strs[j].length() || tmp!=strs[j].charAt(i) ) {
                    return prefix.toString();
                }

            }
            prefix.append(tmp);

        }

        return prefix.toString();

    }
}
