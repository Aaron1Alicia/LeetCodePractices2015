package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/30/15.
 * http://blog.unieagle.net/2012/09/16/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Acontainer-with-most-water/
 * 木桶理论的算法应用，有点意思
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length-1;

        while(i<j) {
           int tmp = Math.min(height[i], height[j])*(j-i);
            area = Math.max(tmp, area);
            if(height[i]>height[j]) {
               j--;
            } else {
                i++;
            }
        }

        return area;
    }
}
