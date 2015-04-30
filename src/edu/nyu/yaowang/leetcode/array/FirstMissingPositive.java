package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 2/14/15.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0) {
            return 1;
        }

        for(int i=0; i<nums.length; i++) {

            if(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
                i--;
            }

        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }

        return nums.length+1;
    }


    public static void main(String[] args) {
        int[] test = {2,1};
        FirstMissingPositive first =
                new FirstMissingPositive();

        System.out.println(first.firstMissingPositive(test));

    }
}
