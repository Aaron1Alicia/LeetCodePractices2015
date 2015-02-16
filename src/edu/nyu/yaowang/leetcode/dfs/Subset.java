package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 * DFS加回溯算法
 */
public class Subset {

    public List<List<Integer>> subsets(int[] S) {
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
        //这里比较关键，注意java的instance都是引用，因此要new新的instance
        ret.add(new LinkedList<Integer>(tmp));
        generate(S, pos+1,tmp, ret);
        //这里是所谓的回溯算法
        tmp.removeLast();
        generate(S, pos+1, tmp, ret);
    }
}
