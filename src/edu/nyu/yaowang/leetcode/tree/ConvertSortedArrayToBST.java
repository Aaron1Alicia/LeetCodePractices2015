package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

/**
 * Created by Yao on 1/21/15.
 */
 public class ConvertSortedArrayToBST {
 public TreeNode sortedArrayToBST(int[] num) {
     if(num.length==0) {
         return null;
     }
  return sortedArrayToBST(num,0,num.length -1);
 }

 private TreeNode sortedArrayToBST(int[] num, int start, int end) {

       TreeNode ret;
       if(start==end) {
         ret = new TreeNode(num[start]);
         return ret;
       } else {
           int mid = (start+end)/2;
           ret = new TreeNode(num[mid]);
           if(mid-1>=start) {
               ret.left = sortedArrayToBST(num, start, mid-1);
           }
           if(mid+1<=end) {
               ret.right = sortedArrayToBST(num, mid+1, end);
           }
           return ret;
       }
 }
}
