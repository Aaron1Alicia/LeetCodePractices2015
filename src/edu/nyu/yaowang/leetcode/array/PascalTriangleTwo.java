package edu.nyu.yaowang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/22/15.
 */
public class PascalTriangleTwo {
    public List<Integer> getRow(int rowIndex) {
        //这是Leetcode对k的定义问题，不用在意
        rowIndex+=1;
        List<Integer> ret = new ArrayList<Integer>();
        if(rowIndex<=0) {
            return ret;
        }

        ret.add(1);

        for(int i=1;i<rowIndex;i++) {
            //注意这里是小于i, 不是小于i-1, 因为arraylist里第i个list里应当有(i+1)个元素
            int tmp = 1;
            for(int j=1;j<i;j++) {
                int cur = ret.get(j);
                ret.set(j, tmp + ret.get(j));
                tmp = cur;
            }
            ret.add(1);
        }

        return ret;

    }
    public static void main(String [ ] args)
    {
        int n=1;
        PascalTriangleTwo test = new PascalTriangleTwo();
        List<Integer> list = test.getRow(n);
        for (int i = 0; i < list.size(); i ++) {
            System.out.printf("%d ", list.get(i));
        }
    }
}
