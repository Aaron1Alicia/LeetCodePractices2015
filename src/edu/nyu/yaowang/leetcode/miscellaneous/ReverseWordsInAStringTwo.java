package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/4/15.
 */
public class ReverseWordsInAStringTwo {
    public void reverseWords(char[] s) {

        //reverse whole string
        int n = s.length;
        reverse(s, 0, n-1);
        int start = 0;

        for(int i=0; i<n; i++) {
            if(s[i]==' ') {
                reverse(s, start, i-1);
                start = i+1;
            }

        }

        //这里很关键!
        reverse(s, start, n-1);

    }

    private void reverse(char[] s, int start, int end) {

        while(start< end) {
            char tmp = s[start];
            s[start]=s[end];
            s[end] = tmp;
            start++;
            end--;
        }

    }


    public static void main(String[] args) {
        ReverseWordsInAStringTwo reverseWordsInAStringTwo=
                new ReverseWordsInAStringTwo();
        String test = "the sky is blue";
        char[] s = test.toCharArray();
        reverseWordsInAStringTwo.reverseWords(s);
        System.out.println(s);

    }
}
