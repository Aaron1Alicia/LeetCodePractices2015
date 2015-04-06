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

        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        dfs(ret, tmp, 0, candidates, target);

        return ret;
    }

    private void dfs(List<List<Integer>> ret,LinkedList<Integer> tmp, int start, int[] candidates, int target) {
        if(target==0){
            ret.add(new LinkedList<Integer>(tmp));
        } else {

            for(int i=start; i<candidates.length; i++) {
                if(target-candidates[i]>=0) {
                    tmp.add(candidates[i]);
                    dfs(ret, tmp, i+1, candidates, target-candidates[i]);
                    tmp.removeLast();

                    //剪枝
                    while(i<candidates.length-1 && candidates[i]==candidates[i+1]) {
                        i++;
                    }
                }
                //这里是剪枝
                else {
                    return;
                }
            }

        }

    }
}
