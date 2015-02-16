package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/31/15.
 * 这一题其实就是注意Java是pass by value,
 * initialize新数组的时候要返回，不能在sub method
 * 里修改引用的指向.
 */
public class PlusONe {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int previous = 1;
        for(int i=n-1;i>=0;i--) {
            int tmp = digits[i];
            int sum = tmp+previous;
            if(i==0 && sum==10) {
                return dealWithHighestBit(digits);
            }
            if(sum==10) {
                digits[i] = 0;
                previous = 1;

            } else {
                digits[i] = sum;
                //这里剪枝，只要没有进位，那么就终止循环
                break;
            }
        }

        return digits;

    }

    private int[] dealWithHighestBit(int[] digits) {
        int n= digits.length;
        int[] newDigits = new int[n+1];

        newDigits[1] = 0;
        newDigits[0] = 1;
        for(int i=2;i<n+1;i++) {
            newDigits[i] = digits[i-1];
        }
        return newDigits;
    }
}
