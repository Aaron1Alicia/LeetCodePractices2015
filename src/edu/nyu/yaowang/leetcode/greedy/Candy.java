package edu.nyu.yaowang.leetcode.greedy;

import java.util.Arrays;

/**
 * Created by Yao on 2/15/15.
 */
public class Candy {
    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i=1; i<n; i++) {
            if(ratings[i]>ratings[i-1]) {
                candies[i] = candies[i-1] +1;
            }
        }

        for(int i=n-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]) {
                candies[i] = candies[i+1] +1;
            }
        }
        int sum =0;

        for(int i=0; i<n; i++) {

            sum += candies[i];
        }

        return sum;
    }
}
