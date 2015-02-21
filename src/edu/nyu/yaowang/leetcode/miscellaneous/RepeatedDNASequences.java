package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yao on 2/17/15.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> ret = new ArrayList<String>();
        if(s==null || s.length()<10) {
            return ret;
        }
        String first = s.substring(0,10);
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        int key = 0;
        for(int i=0; i<10; i++) {
            key = (key<<2) | toInt(first.charAt(i));
        }
        map.put(key, false);

        for(int i=1; i<s.length()-9; i++) {
            key = ((key&0x3ffff)<<2)|toInt(s.charAt(i+9));
            if(!map.containsKey(key)) {
                map.put(key, false);
            } else if(!map.get(key))
            {
                ret.add(s.substring(i,i+10));
                map.put(key,true);

            }


        }

        return ret;
    }

    private int toInt(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            default:return 3;
        }

    }
}
