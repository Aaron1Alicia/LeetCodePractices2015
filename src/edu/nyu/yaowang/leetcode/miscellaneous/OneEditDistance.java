package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/13/15.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n) {
            return isOneEditDistance(t,s);
        }
        if((n-m)>1) {
            return false;
        } else if(n==m) {
            int cnt=0;
            for(int i=0; i<n; i++) {
                if(s.charAt(i)!=t.charAt(i)) {
                    cnt++;
                }
            }

            return cnt==1?true:false;
        } else {
            int i=0, j=0;
            int cnt = 0;

            while(i<n && j<m) {

                if(s.charAt(i)!=t.charAt(j)) {
                    j--;
                    cnt++;
                }
                i++;
                j++;
            }

            if(i==m) {
                return true;
            }

            return cnt==1?true:false;

        }


    }
}
