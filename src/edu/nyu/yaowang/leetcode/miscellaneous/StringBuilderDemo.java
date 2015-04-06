package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 3/22/15.
 */
public class StringBuilderDemo {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("Tutorial");
        System.out.println("string = " + str);

        // insert character value at offset 8
        str.insert(0, 's');

        // prints StringBuilder after insertion
        System.out.print("After insertion = ");
        System.out.println(str.toString());
    }
}
