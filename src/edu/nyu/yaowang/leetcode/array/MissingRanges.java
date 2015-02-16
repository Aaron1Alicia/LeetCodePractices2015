package edu.nyu.yaowang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 2/4/15.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {

        List<String> ret = new ArrayList<String>();
        int n = A.length;
        int expected = lower;

        for(int i=0; i<n;i++) {
            if(A[i]==expected) {
                expected+=1;
            } else if(A[i]> expected) {
                if(expected==A[i]-1) {
                    ret.add(String.valueOf(expected));
                } else {
                    String tmp = "";
                    tmp+=String.valueOf(expected);
                    tmp+="->";
                    tmp+=String.valueOf(A[i]-1);
                    ret.add(tmp);
                }

                expected = A[i]+1;
            }

        }

        if(expected<=upper) {
            if(expected==upper) {
                ret.add(String.valueOf(expected));
            } else {
                String tmp = "";
                tmp+=String.valueOf(expected);
                tmp+="->";
                tmp+=String.valueOf(upper);
                ret.add(tmp);
            }

        }

        return ret;


    }
}
