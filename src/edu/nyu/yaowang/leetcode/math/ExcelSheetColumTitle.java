package edu.nyu.yaowang.leetcode.math;

/**
 * Created by Yao on 2/6/15.
 */
public class ExcelSheetColumTitle {
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        while(n>0) {
            int r = n%26;
            if(r==0) {
                ret.append('Z');
                n--;
            } else {
                ret.append((char)('A' + r-1));
            }
            n/=26;
        }

        ret.reverse();

        return ret.toString();

    }

    public String convertToTitleSimpifiedVersion(int n) {
        StringBuilder ret = new StringBuilder();
        while(n>0) {
            n--;
            ret.append((char)('A' + n%26));
            n/=26;
        }

        ret.reverse();

        return ret.toString();

    }
    public static void main(String[] args) {
        ExcelSheetColumTitle excel = new ExcelSheetColumTitle();
        System.out.println(excel.convertToTitle(26*26));
    }
}
