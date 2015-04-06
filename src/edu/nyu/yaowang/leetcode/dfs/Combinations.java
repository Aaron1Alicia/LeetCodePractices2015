package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        dfs(1, n, k, ret, tmp);
        return ret;
    }

    private void dfs(int start, int end, int k, List<List<Integer>> ret,
                     LinkedList<Integer> tmp) {

        if(k==0) {
            ret.add(new LinkedList<Integer>(tmp));
        }
        //这一句是剪枝，不过现实中，似乎没有这一行也可以过。去掉这行之后就是标准的DFS的配置
        else if( end- start< k-1) {
            return;
        }
        for(int i=start; i<=end; i++) {
            tmp.add(i);
            dfs(i + 1, end, k - 1, ret, new LinkedList<Integer>(tmp));
            tmp.removeLast();
        }

    }
}
