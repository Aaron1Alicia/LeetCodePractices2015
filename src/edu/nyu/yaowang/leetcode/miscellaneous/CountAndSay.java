package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/1/15.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n<=0) {
            return "";
        }

        String cur = "1";

        for(int i=1; i<n; i++) {
            char pre=cur.charAt(0);
            int count = 1;
            StringBuilder ret = new StringBuilder();
            for(int j=1; j<cur.length();j++) {
                if(cur.charAt(j)!=pre) {
                    ret.append(Integer.toString(count));
                    ret.append(cur.charAt(j-1));
                    pre = cur.charAt(j);
                    count = 1;
                } else {
                    count++;
                }

            }
            //注意循环外面还要最后append一下，这是这题的一个小陷进吧算
            ret.append(Integer.toString(count));
            ret.append(cur.charAt(cur.length()-1));
            cur = ret.toString();
        }

        return cur;
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();

        System.out.println(test.countAndSay(3));

    }
}
