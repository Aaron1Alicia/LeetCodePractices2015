package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/5/15.
 * 1. trim
 * 2. 中间连续的空字符的处理
 * 3. 最后一个word的倒置缺乏触发条件
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();


        StringBuilder ret = new StringBuilder();
        int count = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==' ') {
                if(count==0) {
                    String tmp = reverse(s.substring(start, i));
                    ret.append(tmp);
                    ret.append(' ');
                    count++;

                } else {
                    count++;

                }
                start = i+1;
                //count =0;
            } else {
                count = 0;
            }


        }

        String tmp = reverse(s.substring(start));
        ret.append(tmp);

        return ret.toString();

    }


    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return sb.toString();
    }
}
