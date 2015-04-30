package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/31/15.
 */
@SuppressWarnings("unused")
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int ret = 0;

        boolean isInWord = false;
        int length = s.length() -1;

        while(length>=0) {
            char tmp = s.charAt(length);

            if(tmp==' ') {
                if(isInWord) {
                    break;
                }

            } else {
                ret++;
                if(!isInWord) {
                    isInWord = true;
                }

            }
            length--;
        }

        return ret;

    }
}
