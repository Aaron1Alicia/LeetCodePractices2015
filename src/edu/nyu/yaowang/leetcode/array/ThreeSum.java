package edu.nyu.yaowang.leetcode.array;

import java.util.*;

/**
 * Created by Yao on 2/6/15.
 * http://fisherlei.blogspot.com/2013/01/leetcode-3-sum-solution.html
 * 注意有两个地方是去重的trick
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();

        int n = num.length;
        Arrays.sort(num);

        for(int i=0; i<n; i++) {
            int target = num[i];
            int start = i+1;
            int end = n-1;

            while(start<end) {
                if(num[start]+num[end]+target==0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(target);
                    tmp.add(num[start]);
                    tmp.add(num[end]);

                    ret.add(tmp);
                    start++;
                    end--;
                    while(start<end && num[start]==num[start-1]) {
                        start++;
                    }
                    while(start<end && num[end]==num[end+1]) {
                        end--;
                    }
                } else if(num[start]+num[end]+target<0) {
                    start++;
                } else {
                    end--;
                }

            }

            while(i<n-1 && num[i]==num[i+1]) {
                i++;
            }

        }
        return ret;

    }

}
