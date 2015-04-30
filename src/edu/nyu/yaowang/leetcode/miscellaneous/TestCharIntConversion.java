package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 4/8/15.
 */
public class TestCharIntConversion {

    public static void main(String[] strs) {

       int i = 9;
        StringBuilder sb = new StringBuilder();

        char cOfint = (char)(i+'0');
        System.out.println(cOfint);

        if( cOfint =='9') {
           System.out.println("int to c convert correctly");
        }

        char c = '9';

        int intOfc = c-'0';

        if(intOfc == 9) {
            System.out.println("c to int convert correctly");
        }



    }
}
