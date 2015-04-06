package edu.nyu.yaowang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 2/4/15.
 */
@SuppressWarnings("unused")
public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {

        List<String> ret = new ArrayList<String>();
        int lastSeen = lower -1;

        for(int i=0; i<A.length; i++) {

            if(A[i]!=(lastSeen+1)) {
                if(A[i] == (lastSeen+2)) {
                    ret.add(String.valueOf(lastSeen+1));
                } else {
                    String tmp = String.valueOf(lastSeen+1)+"->"+String.valueOf(A[i]-1);
                    ret.add(tmp);
                }
            }

            lastSeen = A[i];
        }

        if(lastSeen!=upper) {
            if(upper == (lastSeen+1)) {
                ret.add(String.valueOf(upper));
            } else {
                String tmp = String.valueOf(lastSeen+1)+"->"+String.valueOf(upper);
                ret.add(tmp);
            }
        }


        return ret;


    }
}
