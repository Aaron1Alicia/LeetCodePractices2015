package edu.nyu.yaowang.leetcode.dp;

/**
 * Created by Yao on 1/21/15.
 * 注意这不是普通的tree, 是一棵BST
 * Typical dynamical programming
 * 以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。
 */
@SuppressWarnings("unused")
public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;


        for(int i=2;i<=n;i++) {
            for(int j=0;j<i;i++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
}
