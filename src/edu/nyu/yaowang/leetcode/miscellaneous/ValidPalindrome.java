package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/2/15.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        String tmp = parse(s);
        tmp = tmp.toLowerCase();
        int start = 0;
        int end = tmp.length()-1;

        while(start<end) {
            if(tmp.charAt(start)!=tmp.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private String parse(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length();i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }

        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";

        ValidPalindrome validPalindrome = new ValidPalindrome();
        if(validPalindrome.isPalindrome(test)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }


}
