package edu.nyu.yaowang.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yao on 2/16/15.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(int i =0; i<num.length; i++) {
            int tmp = num[i];
            int[] left = Arrays.copyOfRange(num, i+1, num.length);
            List<List<Integer>> three = threeSum(left, target-tmp);
            if(three.size()>0) {
                for(int j = 0; j<three.size(); j++) {
                    List<Integer> four = new ArrayList<Integer>() ;
                    four.add(tmp);
                    four.addAll(three.get(j));
                    ret.add(four);
                }


            }
            while(i< num.length-1 &&tmp==num[i+1]) {
                i++;
            }
        }
        return ret;

    }




    private List<List<Integer>> threeSum(int[] num, int sum) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();

        int n = num.length;
        Arrays.sort(num);

        for(int i=0; i<n; i++) {
            int target = num[i];
            int start = i+1;
            int end = n-1;

            while(start<end) {
                if(num[start]+num[end]+target==sum) {
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
                } else if(num[start]+num[end]+target<sum) {
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
