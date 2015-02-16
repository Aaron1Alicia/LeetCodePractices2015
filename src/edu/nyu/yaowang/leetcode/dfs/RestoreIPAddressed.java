package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yao on 1/24/15.
 */
public class RestoreIPAddressed {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        //这里要提前check, 否则后面check string是否valid的部分容易出问题
        if (s.length()<4||s.length()>12) return ret;
        // 典型的DFS或者Recursion, 将复杂度为3的问题，一步步拆解为复杂度为0的问题
        dfs(s, 3, "", ret);
        return ret;
    }


    private void dfs(String s, int left,
                     String tmp, List<String> ret) {
        // Base case, 要check剩余的部分是满足要求的
        if(left==0 && isValid(s)) {
            ret.add(tmp+s);

        } else {
            //这里有个小细节，就是要check剩下的长度
            for(int i=1;i<4 && i<s.length();i++) {
                //这里也是一个细节，就是只有valid,才加入DFS
                if(isValid(s.substring(0,i))) {
                    dfs(s.substring(i), left-1, tmp+s.substring(0,i)+".", ret);
                }
            }
        }

    }

    private boolean isValid(String s) {
        if(s.charAt(0)=='0') {
            return s.equals("0");
        }

        int value = Integer.parseInt(s);
        if(value>255 || value<0) {
            return false;
        }

        return true;
    }
}
