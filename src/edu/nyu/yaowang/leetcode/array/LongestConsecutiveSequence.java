package edu.nyu.yaowang.leetcode.array;

import java.util.HashSet;

/**
 * Created by Yao on 1/31/15.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i: num) {
            set.add(i);
        }

        int max = 0;

        //不能在iterate set的同时删除元素
        for(int i: num) {
            set.remove(i);
            int cur = 1;
            int tmp = i-1;

            while(set.contains(tmp))  {
                set.remove(tmp);
                cur+=1;
                tmp-=1;
            }

            tmp = i+1;
            while (set.contains(tmp)) {
                set.remove(tmp);
                cur+=1;
                tmp+=1;
            }

            max= Math.max(cur,max);

        }

        return max;

    }


}
