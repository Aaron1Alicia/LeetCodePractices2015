package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/2/15.
 */
@SuppressWarnings("unused")
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSum = 0;
        int sum = 0;

        int i = 0;
        int start = 0;
        for(; i<n; i++) {
            int diff = gas[i] - cost[i];
            sum+=diff;
            totalSum +=diff;

            if(sum<0) {
                sum = 0;
                start = i+1;
            }

        }

        return totalSum>=0? start:-1;
    }
}
