package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/2/15.
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int lengthA = a.length()-1;
        int lengthB = b.length()-1;
        int sum = 0;
        int previous = 0;

        while (lengthA>=0 || lengthB>=0) {
            int valueA=0;
            int valueB=0;
            if(lengthA>=0) {
                valueA = Integer.parseInt(a.substring(lengthA, lengthA+1));
            }
            if(lengthB>=0) {
                valueB = Integer.parseInt(b.substring(lengthB, lengthB+1));
            }
            sum = valueA+valueB+previous;
            if(sum==0) {
                previous=0;
                sb.append('0');
            } else if(sum==1) {
                previous=0;
                sb.append('1');
            } else if(sum==2) {
                previous=1;
                sb.append('0');

            } else {
                previous=1;
                sb.append('1');
            }
            lengthA--;
            lengthB--;
        }

        if(previous==1) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();

    }

    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));

    }
}
