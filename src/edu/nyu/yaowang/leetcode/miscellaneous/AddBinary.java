package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/2/15.
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        if(a==null || a.length()==0) {
            return b;
        } else if(b==null || b.length()==0) {
            return a;
        }

        if(b.length()>a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int lengthOfA = a.length();
        int lengthOfB = b.length();

        String A = new StringBuilder(a).reverse().toString();
        String B = new StringBuilder(b).reverse().toString();

        StringBuilder sb = new StringBuilder();

        int pre = 0;
        int i = 0;

        for(;i<lengthOfB; i++) {
            int tmpA = A.charAt(i)=='1'?1:0;
            int tmpB = B.charAt(i)=='1'?1:0;

            sb.append((tmpA+tmpB+pre)%2);
            pre = (tmpA+tmpB+pre)/2;
        }

        while(i<lengthOfA) {
            int tmp = A.charAt(i)=='1'? 1:0;
            sb.append((pre+tmp)%2);
            pre = (pre+tmp)/2;
            i++;
        }

        if(i==lengthOfA && pre==1) {
            sb.append('1');
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));

    }
}
