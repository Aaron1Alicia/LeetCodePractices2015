package edu.nyu.yaowang.leetcode.array;

import java.util.Arrays;

/**
 * Created by Yao on 2/7/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int ret = num[0] + num[1] + num[2];

        int n = num.length;
        Arrays.sort(num);

        for(int i=0; i<n; i++) {
            int fixed = num[i];
            int start = i+1;
            int end = n-1;

            while(start<end) {
                int tmp = num[start]+num[end]+fixed;
                if(tmp==target) {
                    return target;
                } else if(tmp<target) {
                    if(Math.abs(tmp-target)< Math.abs(ret-target)) {
                        ret = tmp;
                    }
                    start++;
                } else {
                    if(Math.abs(tmp-target)< Math.abs(ret-target)) {
                        ret = tmp;
                    }
                    end--;
                }

            }

            //这里是一个剪枝，由two sum题得来
            while(i<n-1 && num[i]==num[i+1]) {
                i++;
            }

        }
        return ret;
    }
}
