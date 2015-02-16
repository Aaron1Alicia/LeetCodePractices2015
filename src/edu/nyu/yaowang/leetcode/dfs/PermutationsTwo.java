package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
public class PermutationsTwo {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();

        boolean[] isVisited = new boolean[num.length];
        Arrays.sort(num);
        generate(ret, tmp, num, isVisited);
        return ret;
    }


    private void generate(List<List<Integer>> ret, LinkedList<Integer> tmp,
                          int[] num, boolean[] isVisited) {
        if(tmp.size()==num.length) {
            ret.add(new LinkedList<Integer>(tmp));
            return;
        }

        for(int i=0;i<num.length;i++) {
            if(isVisited[i]==false) {
                isVisited[i] = true;
                tmp.add(num[i]);
                generate(ret, tmp, num, isVisited);
                tmp.removeLast();
                isVisited[i] = false;
                while(i<num.length-1 && num[i]==num[i+1]) {
                    i++;
                }
            }
        }

    }
}
