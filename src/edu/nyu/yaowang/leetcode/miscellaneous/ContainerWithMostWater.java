package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/30/15.
 * http://blog.unieagle.net/2012/09/16/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Acontainer-with-most-water/
 * 木桶理论的算法应用，有点意思
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ret = 0;
        if(height==null || height.length==0) {
            return ret;
        }

        int l = 0;
        int r = height.length-1;

        while(l<r) {
            int bottleneck = Math.min(height[l], height[r]);
            ret = Math.max(ret, (r-l)*bottleneck);

            if(height[l]>height[r]) {
                r--;
            } else {
                l++;
            }

        }

        return ret;
    }
}
