package edu.nyu.yaowang.leetcode.tree;

import edu.nyu.yaowang.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Yao on 2/5/15.
 * http://fisherlei.blogspot.com/2012/12/leetcode-recover-binary-search-tree.html
 * Morris traversal的变形
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {

       TreeNode cur = root;
       TreeNode pre = null;
        TreeNode f1 = null;
        TreeNode f2 = null;
        TreeNode parent= null;
        boolean found = false;

        while(cur!=null) {
            if(cur.left==null) {
                if(parent!=null && parent.val > cur.val)
                {
                    if(!found)
                    {
                        f1 = parent;
                        found = true;
                    }
                    f2 = cur;
                }
                parent = cur;
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur) {
                    pre = pre.right;
                }

                if(pre==null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    if(parent.val > cur.val)
                    {
                        if(!found)
                        {
                            f1 = parent;
                            found = true;
                        }
                        f2 = cur;
                    }
                    parent = cur;
                    cur = cur.right;

                }



            }


        }

        if(f1!=null&&f2!=null) {
            int tmp=f1.val;
            f1.val = f2.val;
            f2.val = tmp;
        }


    }

    /*
      O(log(n))空间复杂度
     */
    public void recoverTreeUsingStack(TreeNode root) {

        Stack<TreeNode> st = new Stack<TreeNode>();
        LinkedList<TreeNode> record = new LinkedList<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;

        while(cur!=null || !st.isEmpty()) {
            if(cur!=null) {
                st.push(cur);
                cur = cur.left;
            } else {

                cur = st.pop();
                if(pre!=null && pre.val>cur.val) {
                    if(record.size()==0) {
                        record.add(pre);
                        record.add(cur);
                    } else {

                        record.removeLast();
                        record.add(cur);
                        break;
                    }
                }


                pre = cur;
                cur = cur.right;

            }

        }

        int temp = record.get(0).val;
        record.get(0).val = record.get(1).val;
        record.get(1).val = temp;

    }
}
