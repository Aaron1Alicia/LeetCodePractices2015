package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/31/15.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length()==0) {
            return 0;
        }
        int length = 0;
        int end=0;
        for(int i=s.length()-1; i>=0;i--) {
            if(s.charAt(i)==' ') {
                continue;
            }
            else {
                end = i;
                break;
            }

        }

        for(int i=end; i>=0;i--) {
            if(s.charAt(i)==' ') {
                return length;
            }
            else {
                length++;
            }

        }

        return length;

    }
}
