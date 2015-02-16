package edu.nyu.yaowang.leetcode.array;

/**
 * Created by Yao on 2/13/15.
 */
public class Permutations {
    public String getPermutation(int n, int k) {

        int permutation = 1;
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            permutation*=(i+1);
            num[i] = i+1;
        }

        StringBuilder sb = new StringBuilder();

        //只用在开头减去1
        k-=1;

        for(int i=0; i<n;i++) {
            permutation/=(n-i);
            int tmp = k/permutation;

            //注意这里算出来的tmp是index, 而不是具体的值
            sb.append(Integer.toString(num[tmp]));

            //这一步也是一个关键性的思路
            for(int j=tmp; j<n-1-i;j++ ) {
                num[j] = num[j+1];

            }

            k%=permutation;

        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(1);
        char tmp = 1+'a';
        System.out.println(tmp);


    }
}
