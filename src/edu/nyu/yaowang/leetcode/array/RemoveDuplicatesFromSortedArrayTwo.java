package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 1/23/15.
 * 这是第二遍更新的算法，得到的是一个通解，使用与n>2的所有情况
 */
@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) {
            return 0;
        }
        int pre = A[0] ;

        int n = A.length;
        //记录non-duplicate的位置
        int j = -1;
        int count = 1;


        for(int i=1; i<n; i++) {
            if(A[i] != pre) {

                for(int k = 0; k< Math.min(count,2); k++) {

                    A[++j] = pre;

                }
                pre = A[i];
                count = 1;

            } else {
                count++;
            }

        }

        // 这里是处理结尾部分最后一个值，因为循环最终会跳出，而最后一个值会被skip
        for(int k = 0; k< Math.min(count,2); k++) {
            A[++j] = pre;

        }

        return j+1;
    }
}
