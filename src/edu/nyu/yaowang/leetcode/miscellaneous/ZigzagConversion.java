package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/11/15.
 * String的题一定要注意edge case
 */
public class ZigzagConversion {
    public String convert(String s, int nRows) {
        if(s == null || s.length()==0 || nRows <=0)
            return "";

        //这个edge case很重要
        if(nRows==1) {
            return s;
        }

        int size = 2*nRows-2;
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<nRows; i++) {
            for(int j=i; j<s.length(); j+=size) {
                ret.append(s.charAt(j));

                //注意这个条件，第一个和最后一个都只用加一次，然后还有一个边界的检查
                if(i!=0 && i!=nRows-1 && j+size-2*i<s.length()) {
                    ret.append(s.charAt(j+size-2*i));
                }

            }
        }

        return ret.toString();
    }


    public static void main(String[] args) {

        String test = "PAYPALISHIRING";
        ZigzagConversion zigzagConversion =
                new ZigzagConversion();

        System.out.println(zigzagConversion.convert(test, 3));
    }
}
