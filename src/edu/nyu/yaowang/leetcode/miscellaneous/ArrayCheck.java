package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 3/20/15.
 */
public class ArrayCheck {
    private String label = "ArrayCheck";
    public ArrayCheck() {
        label = "CheckArray";
    }

    public String getLabel() {
        return label;
    }


    public static void main(String[] args) {
        ArrayCheck arrayCheck = new ArrayCheck();
        System.out.println(arrayCheck.getLabel());
        int[] test = new int[2];

        if(test instanceof Object) {
            System.out.println("test is an object");
        }
        if(test!=null) {
            System.out.println("Not null!");
        }
        test = null;
        if(test == null) {
            System.out.println("Can be null!");
        }
    }
}
