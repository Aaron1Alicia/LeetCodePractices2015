package edu.nyu.yaowang.leetcode.ood;

import java.util.*;

/**
 * Created by Yao on 1/31/15.
 * 由于这是一道OOD类型的题,所以和面试官讨论使用不同数据结构的trade-off非常重要.
 * OOD类问题有的时候why比how更重要
 */
@SuppressWarnings("unused")
public class TwoSumThree {
    /*
    HashMap存储,节省空间. 如果用List的话, 还要排序或者再用HashMap求解
     */
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        if(map.containsKey(number)) {
            map.put(number, map.get(number)+1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        Set<Integer> set = map.keySet();

        for(Integer i: set) {
            int j = value -i;
            if(i==j) {
                if(map.get(i)>=2) {
                    return true;
                }

            } else {
                if(map.containsKey(j)) {
                    return true;
                }
            }
        }

        return false;
    }
}
