package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/11/15.
 * 这道题毫无技术含量，但是要注意edge case
 * String的题edge case都很多
 */
public class ZigzagConversion {
    public String convert(String s, int nRows) {

        //注意这个edge case
        if(nRows==1) {
            return s;
        }
        StringBuffer[] tmp = new StringBuffer[nRows];
        for(int i=0; i<nRows; i++) {
            tmp[i] = new StringBuffer();
        }
        int n = nRows+(nRows-2);

        for(int i=0; i< s.length();i++) {
            int left = i%n;

            if(left<nRows) {
                tmp[left].append(s.charAt(i));
            } else {
                tmp[2*nRows-2-left].append(s.charAt(i));
            }

        }

        String ret = "";
        for(int i=0; i<tmp.length;i++) {
            ret+=tmp[i].toString();
        }

        return ret;
    }


    public static void main(String[] args) {

        String test = "PAYPALISHIRING";
        ZigzagConversion zigzagConversion =
                new ZigzagConversion();

        System.out.println(zigzagConversion.convert(test, 3));
    }
}
