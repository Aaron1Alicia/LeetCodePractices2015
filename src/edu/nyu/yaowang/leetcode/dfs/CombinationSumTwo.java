package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0,  ret, tmp);

        return ret;


    }


    private void dfs(int[] candidates, int target, int pos, List<List<Integer>> ret,
                     LinkedList<Integer> tmp) {
        if(target==0) {
            ret.add(new LinkedList<Integer>(tmp));
            return;
        } else if(target < 0) {
            return;
        }

        //这题的关键是从pos这里开始迭代，否则会产生不递增的结果
        for(int i=pos; i< candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(candidates, target-candidates[i],i+1,ret, tmp);
            tmp.removeLast();
            while(i<candidates.length-1 && candidates[i]==candidates[i+1]) {
                i++;
            }
        }

    }
}
