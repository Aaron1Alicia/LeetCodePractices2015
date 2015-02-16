package edu.nyu.yaowang.leetcode.ood;

import java.util.LinkedHashMap;

/**
 * Created by Yao on 2/14/15.
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> mem =
            new LinkedHashMap<Integer, Integer>();

    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(mem.containsKey(key)) {
            return mem.get(key);
        } else {
            return -1;
        }

    }

    public void set(int key, int value) {

    }
}
