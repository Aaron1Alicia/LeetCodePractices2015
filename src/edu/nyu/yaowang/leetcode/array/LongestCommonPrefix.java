package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 2/1/15.
 */
@SuppressWarnings("unused")
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<strs[0].length()) {
            char c = strs[0].charAt(index);
            for(int i=1; i<strs.length;i++) {

                if(index>=strs[i].length() || strs[i].charAt(index)!=c) {
                    return sb.toString();
                }

            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }

    public String longestCommonSuffix(String[] strs) {

        if(strs==null || strs.length==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<strs[0].length()) {
            char c = strs[0].charAt(strs[0].length()-index-1);
            for(int i=1; i<strs.length;i++) {

                int tmp = strs[i].length()-1-index;
                if(index>=strs[i].length() || strs[i].charAt(tmp)!=c) {
                    return sb.reverse().toString();
                }

            }
            sb.append(c);
            index++;
        }
        return sb.reverse().toString();

    }


    public static void main(String[] strs) {

        String[] test= {"sting", "heading", "king"};
        LongestCommonPrefix testSuffix = new LongestCommonPrefix();
        System.out.println(testSuffix.longestCommonSuffix(test));
    }
}
