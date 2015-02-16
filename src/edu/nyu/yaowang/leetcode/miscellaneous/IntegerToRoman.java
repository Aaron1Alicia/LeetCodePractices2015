package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/29/15.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        char[] roman = {'I','V','X', 'L','C','D','M'};
        int scale = 1000;
        String ret ="";

        for(int i = 6; i>=0; i=i-2) {

            int cur = num/scale;
            if(cur== 0) {
                //continue;
            } else if(cur<=3) {
                for(int j=0;j<cur;j++) {
                    ret+=roman[i];
                }

            } else if(cur==4) {
                ret+=roman[i];
                ret+=roman[i+1];

            } else if(cur==5) {
                ret+=roman[i+1];

            } else if(cur<=8){
                ret+=roman[i+1];
                for(int j=cur;j>5;j--) {
                    ret+=roman[i];
                }

            } else {
                ret+=roman[i];
                ret+=roman[i+2];
            }

            num%=scale;
            scale = scale/10;
        }

        return ret;
    }

    public static void main(String[] args) {
        int test = 1;
        IntegerToRoman integerToRoman = new IntegerToRoman();

        System.out.println(integerToRoman.intToRoman(test));

    }
}
