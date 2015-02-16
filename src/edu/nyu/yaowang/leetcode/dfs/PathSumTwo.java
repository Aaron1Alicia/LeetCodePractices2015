package edu.nyu.yaowang.leetcode.dfs;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 2/1/15.
 */
public class PathSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root==null) {
            return ret;
        }
        LinkedList<Integer> tmp = new LinkedList<Integer>();

        dfs(ret, tmp, root, sum);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, LinkedList<Integer> tmp,
                     TreeNode root,int sum) {
        if(root.left==null && root.right==null){
            if(sum==root.val) {
                tmp.add(root.val);
                ret.add(new LinkedList<Integer>(tmp));
                //注意这里要remove掉
                tmp.removeLast();
            }

        } else {
            tmp.add(root.val);
            if(root.left!=null) {
                dfs(ret, tmp, root.left, sum-root.val);
            }
            if(root.right!=null) {
                dfs(ret, tmp, root.right, sum-root.val);
            }
            tmp.removeLast();
        }

    }
}
