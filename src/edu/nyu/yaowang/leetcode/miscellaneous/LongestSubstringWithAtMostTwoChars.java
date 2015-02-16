package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/31/15.
 * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-longest-substring-with-at-most-two-distinct-characters
 * leetcode官方出的书里也收录了这道题
 */
public class LongestSubstringWithAtMostTwoChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // i是sliding window的左端
        int i=0;
        int j=-1;
        int maxLen = 0;

        for(int k =1; k<s.length();k++) {
            if(s.charAt(k)==s.charAt(k-1)) {
                continue;
            }

            //说明出现了第3个字符
            if(j>=0 && s.charAt(k)!=s.charAt(j)) {
                maxLen = Math.max(k-1-i+1, maxLen);
                //i是sliding window的左端
                i = j+1;
            }

            //j是不与s.charAt(k-1)相等的另一个字符的最后位置
            j=k-1;

        }

        //注意，这里有个edge case, 当然也可以通过延长数组来解决
        return Math.max(s.length() - i, maxLen);

    }
}
