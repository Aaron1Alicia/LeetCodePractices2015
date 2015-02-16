package edu.nyu.yaowang.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yao on 1/25/15.
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        LinkedList<String> tmp = new LinkedList<String>();
        dfs(ret, tmp,s );
        return ret;
    }


    private void dfs(List<List<String>> ret,LinkedList<String> tmp,String s) {

        if(s.length()==0) {
            ret.add(new LinkedList<String>(tmp));
        } else {

            for(int i=1; i<=s.length();i++) {
                if(isPalindrome(s.substring(0, i))) {
                    tmp.add(s.substring(0, i));
                    dfs(ret,tmp, s.substring(i));
                    tmp.removeLast();
                }
            }
        }

    }


    private boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length()-1;

        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        boolean isPalindrome = false;
        String test = "abba";
        PalindromePartition palindromePartition = new PalindromePartition();

        isPalindrome = palindromePartition.isPalindrome(test);

        if(isPalindrome) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
