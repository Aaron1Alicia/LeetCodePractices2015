package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/2/15.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int n = gas.length;
        int sum = 0;
        int start=0;

        for(int i=0; i<n; i++) {
            int tmp=gas[i]-cost[i];
            sum+=tmp;
            total+=tmp;
            if(sum<0) {
                sum = 0;
                start = i+1;
            }

        }
        if(total<0) {
            return -1;
        }

        return start;

    }
}
