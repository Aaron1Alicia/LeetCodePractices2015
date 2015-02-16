package edu.nyu.yaowang.leetcode.ood;

import java.util.*;

/**
 * Created by Yao on 1/31/15.
 */
public class TwoSumThree {
    List<Integer> numbers = new ArrayList<Integer>();
    public void add(int number) {
        numbers.add(number);
    }

    public boolean find(int value) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            int numNeeded = value - numbers.get(i);
            if (map.containsKey(numNeeded)) {
                return true;
            } else {
                map.put(numbers.get(i), i);
            }
        }

        return false;

    }
}
