package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
@SuppressWarnings("unused")
public class SubsetTWo {
    public List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        ret.add(tmp);
        Arrays.sort(S);
        generate(S, 0, tmp, ret);
        return ret;
    }

    private void generate(int[] S, int pos, LinkedList<Integer> tmp,
                          List<List<Integer>> ret) {
        if(pos==S.length){
            return;
        }

        tmp.add(S[pos]);
        ret.add(new LinkedList<Integer>(tmp));
        generate(S, pos+1,tmp, ret);
        //这里是所谓的回溯算法
        tmp.removeLast();
        //这是与subset1思路不同的地方, remove之后再加时，不要加和这次相同的。
        while(pos<S.length-1 && S[pos]==S[pos+1]) {
            pos++;
        }
        generate(S, pos+1, tmp, ret);
    }
}
