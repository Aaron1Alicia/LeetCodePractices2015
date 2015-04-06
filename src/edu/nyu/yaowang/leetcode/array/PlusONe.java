package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/31/15.
 * 两种解法，一种是修改原有数组，还有一种是不修改原有数组。
 */
@SuppressWarnings("unused")
public class PlusONe {
    /*
     This method will modify the original array
     */
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

    public int[] plusOneNewArray(int[] digits) {
        if(digits==null || digits.length==0) {
            return digits;
        }

        int n = digits.length;
        int pre = 1;
        int[] ret = new int[n];
        for(int i=n-1; i>=1; i--) {

            int cur = digits[i] + pre;
            if(cur>=10) {
                ret[i] = cur-10;
                pre = 1;
            } else {
                ret[i] = cur;
                for(int j=0; j<i; j++) {
                    ret[j] = digits[j];
                }
                return ret;
            }

        }

        if(pre==0) {
            ret[0] = digits[0];
            return ret;
        } else {

            int temp = digits[0] + pre;
            if(temp >= 10) {
                int[] finalRet = new int[n+1];
                finalRet[0] = 1;
                finalRet[1] = temp-10;

                for(int i=1; i<n; i++) {
                    finalRet[i+1] = ret[i];
                }

                return finalRet;

            } else {
                ret[0] = temp;
                return ret;
            }

        }

    }


}
