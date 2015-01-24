package edu.nyu.yaowang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/22/15.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(numRows<=0) {
            return ret;
        }

        List<Integer> start = new ArrayList<Integer>();
        List<Integer> pre;

        start.add(1);
        ret.add(start);

        for(int i=1;i<numRows;i++) {
            pre = ret.get(i-1);
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            //注意这里是小于i, 不是小于i-1, 因为arraylist里第i个list里应当有(i+1)个元素
            for(int j=1;j<i;j++) {
                cur.add(pre.get(j-1)+pre.get(j));
            }
            cur.add(1);
            ret.add(cur);
        }

        return ret;

    }

    public static void main(String [ ] args)
    {
        int n=4;
        PascalTriangle test = new PascalTriangle();
        List<List<Integer>> list = test.generate(n);
        for (int i = 0; i < list.size(); i ++) {
            for (int j = 0; j < list.get(i).size(); j ++) {
                System.out.printf("%d ", list.get(i).get(j));
            }
            System.out.println();
        }
    }

}
