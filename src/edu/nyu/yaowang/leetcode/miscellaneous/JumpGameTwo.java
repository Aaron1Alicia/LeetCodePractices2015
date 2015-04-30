package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/1/15.
 * http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 */
public class JumpGameTwo {
    public int jump(int[] A) {
        int n = A.length;
        int currentBound =0;
        int lastBound = 0;
        int ret=0;

        for(int i=0; i<A.length;i++) {
            if(i>lastBound) {
                ret++;
                lastBound = currentBound;
            }

            currentBound = Math.max(A[i]+i, currentBound);

        }

        return ret;

    }

    public int jumpDP(int[] A) {
        if(A.length < 2) return 0;
        int[] dist = new int[A.length];
        for(int i = 0; i < A.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[A.length - 1] = 0;
        for(int i = A.length - 2; i >= 0; i--){
            int minDist = Integer.MAX_VALUE;
            for(int j = 1; j <= A[i] && i + j < A.length; j++){
                minDist = Math.min(dist[i+j] + 1, minDist);
            }
            dist[i] = minDist;
        }
        return dist[0];
    }


    public static void main(String[] args) {

        int[] A = {2,4,1,1,4,2};
        JumpGameTwo jumpGameTwo = new JumpGameTwo();

        System.out.println(jumpGameTwo.jumpDP(A));

    }
}
