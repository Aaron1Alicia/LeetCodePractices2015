package edu.nyu.yaowang.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yao on 1/7/15.
 *
 * Two solutions:
 * 1. Hash
 * 2. Two pointer
 */

@SuppressWarnings("unused")
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            int numNeeded = target - numbers[i];
            if (map.containsKey(numNeeded)) {
                return new int[]{map.get(numNeeded) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }

        throw new IllegalArgumentException("No result...");

    }

}
