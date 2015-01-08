package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/7/15.
 * 水题，26进制转10进制
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int sum=0;

        for(int i=0;i<charArray.length;i++) {
            int tmp=charArray[i]-'A'+1;
            sum=sum*26+tmp;
        }

        return sum;
    }

    public static void main(String [] args){
        String test = "ZB";
        ExcelSheetColumnNumber testNumber = new ExcelSheetColumnNumber();
        System.out.println(testNumber.titleToNumber(test));

    }
}
