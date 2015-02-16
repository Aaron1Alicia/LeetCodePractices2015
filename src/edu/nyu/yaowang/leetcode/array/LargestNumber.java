package edu.nyu.yaowang.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yao on 2/14/15.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {

        int n = num.length;
        String[] tmp = new String[n];

        for(int i=0; i<n; i++) {
            tmp[i] = num[i]+"";
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(tmp, comparator);
        StringBuilder sb = new StringBuilder();
        if(tmp[0].equals("0")) {
            return "0" ;
        }

        for(int i=0; i<n; i++) {
            sb.append(tmp[i]);
        }

        return sb.toString();

    }
}
