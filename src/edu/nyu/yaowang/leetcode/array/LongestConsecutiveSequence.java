package edu.nyu.yaowang.leetcode.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Yao on 1/31/15.
 * 不能sort, 又要O(n), 只能用空间换时间了。
 * 注意一下iterator的用法
 */
@SuppressWarnings("unused")
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num==null || num.length==0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();

        for(int i=0; i<num.length; i++) {
            set.add(num[i]);
        }

        int max = 1;

        while(set.size()>0) {

            Iterator<Integer> iter = set.iterator();

            int cur = iter.next();

            set.remove(cur);
            int tmp = cur+1;
            int count = 1;

            while(set.contains(tmp)) {
                set.remove(tmp);
                count+=1;
                tmp+=1;

            }

            tmp = cur-1;

            while(set.contains(tmp)) {
                set.remove(tmp);
                tmp-=1;
                count+=1;
            }

            max = Math.max(max, count);

        }


        return max;

    }


}
