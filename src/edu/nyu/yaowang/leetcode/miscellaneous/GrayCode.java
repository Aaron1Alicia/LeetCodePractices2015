package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/28/15.
 * n+1的gray code等于n的gray code的顺序+(n的gray code的倒序比特或i<<i)
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();

        ret.add(0);

        for(int i=0;i<n;i++) {
            int highestBit = 1<<i;
            int size = ret.size();

            for(int j=size-1; j>=0; j--) {
                int tmp = ret.get(j);
                ret.add(tmp | highestBit);

            }

        }

        return ret;
    }
}
