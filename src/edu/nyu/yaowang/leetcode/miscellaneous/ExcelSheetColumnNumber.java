package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/7/15.
 * 水题，26进制转10进制
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int n = s.length();
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum*=26;
            sum+=(s.charAt(i)-'A'+1);
        }

        return sum;
    }

}
