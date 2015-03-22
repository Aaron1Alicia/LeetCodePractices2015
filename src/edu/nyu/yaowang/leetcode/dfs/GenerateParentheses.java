package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
@SuppressWarnings("unused")
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> ret = new ArrayList<String>();
        if(n<=0) {
            return ret;
        }
        generate(n, n, ret, "");
        return ret;

    }

    private void generate(int left, int right, List<String> ret, String tmp) {
        if(left==0 && right ==0) {
            // string是改变时自动new新的string, 因此这里回避了Java的instance是reference的问题
            ret.add(tmp);
            return;
        } else {
            if(left>0) {
                generate(left-1, right, ret, tmp+"(");
            }

            //这个条件是这一题的关键
            if(right>left) {
                generate(left, right-1, ret, tmp+")");
            }
        }


    }
}
