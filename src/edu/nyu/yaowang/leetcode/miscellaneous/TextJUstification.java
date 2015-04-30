package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 2/22/15.
 */
public class TextJUstification {

        public List<String> fullJustify(String[] words, int L) {

            List<String> ret = new ArrayList<String>();
            //  if(words==null || words.length==0) {
            //     return ret;
            // }

            int start =0;
            int curLength = 0;
            for(int i=0; i<words.length; i++) {

                curLength+=words[i].length()+1;
                if(curLength>L+1) {
                    curLength -= words[i].length()+2;
                    int leftSpace = L - curLength;
                    ret.add(concatenate(words, start, i-1, leftSpace));
                    start = i;
                    i--;
                    curLength = 0;
                } else if(curLength==L+1) {
                    curLength-=1;
                    ret.add(concatenate(words, start, i, 0));
                    start = i+1;
                    curLength = 0;
                }

            }

            //别忘了处理最后的corner case, 很多循环类问题都有类似的处理。
            if(curLength!=0) {

                StringBuilder sb = new StringBuilder();
                int leftSpace = L - curLength+1;
                for(int i=start; i<words.length; i++) {
                    sb.append(words[i]+" ");
                }

                sb.deleteCharAt(sb.length()-1);
                for(int i=0; i<leftSpace; i++) {
                    sb.append(" ");
                }
                ret.add(sb.toString());

            }


            return ret;
        }

    private String concatenate(String[] words, int start, int end, int leftSpace) {
        StringBuilder sb = new StringBuilder();
        int num = end-start;
        if(num==0) {
            sb.append(words[start]);

            for(int i=1; i<=leftSpace;i++) {
                sb.append(" ");
            }
            return sb.toString();


        }
        int each = leftSpace/num;
        int left = leftSpace%num;

        for(int i=0; i+start<end; i++) {
            sb.append(words[i+start]+" ");
            for(int j=1;j<=each;j++) {
                sb.append(" ");
            }

            if(i<left) {
                sb.append(" ");
            }

        }

        sb.append(words[end]);
        return sb.toString();

    }
}
