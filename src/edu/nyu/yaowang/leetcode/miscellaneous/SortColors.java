package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/21/15.
 */
public class SortColors {
    public void sortColors(int[] A) {

        int blue = A.length;
        int red = -1;
        int i =0;

        //这个循环退出条件也十分关键
        while(i < blue ) {
            if(A[i]==1) {
                i++;
            } else if(A[i]==0) {
                red+=1;
                int tmp = A[i];
                A[i] = A[red];
                A[red] = tmp;
                //这个i++十分关键
                i++;
            } else  if(A[i]==2) {
                blue--;
                int tmp = A[i];
                A[i] = A[blue];
                A[blue] = tmp;
            }

        }
    }


    public static void main(String [] args)
    {
        //int[] A = {0,1,1,0,1,2};
        //int[] A = {1,2,0};
        int[] A = {0};
        //int[] A = {2, 0};

        SortColors color = new SortColors();
        color.sortColors(A);
        for (int i:A) {

            System.out.println(i);
        }
    }
}
