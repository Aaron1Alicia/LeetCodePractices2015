package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/27/15.
 * 这是twoSum的two pointers的解法，用于解twoSum2 这道题。
 * 其实twosum2还没two sum难呢
 */
public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {

        int[] ret = new int[2];
        int start = 0;
        int end = numbers.length-1;

        while(start<end) {

            if(numbers[start]+numbers[end]==target) {
                ret[0] = start+1;
                ret[1] = end+1;
                //注意这里要break
                break;
            } else if(numbers[start]+numbers[end]>target) {
                end--;
            } else {
                start++;
            }

        }

        return ret;
    }

    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        TwoSumTwo twoSumTwo = new TwoSumTwo();
        int[] ret=twoSumTwo.twoSum(test, 9);

        for(int e:ret){
            System.out.println(e);
        }
    }

}
