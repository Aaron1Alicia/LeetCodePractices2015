package edu.nyu.yaowang.leetcode.math;

/**
 * Created by Yao on 1/22/15.
 * http://blog.csdn.net/linhuanmars/article/details/20024837
 * 思路很简单，一般来说，越是思路简单的代码，越要考虑周全。
 */
public class ReverseInteger {
    public int reverse(int x) {
        //注意Integer.MIN_VALUE的绝对值是比Integer.MAX_VALUE大1的，所以经常要单独处理。
        if(x==Integer.MIN_VALUE)
            return 0;
        int num = Math.abs(x);
        int res = 0;
        while(num!=0)
        {
            if(res>(Integer.MAX_VALUE-num%10)/10)
                return 0;
            res = res*10+num%10;
            num /= 10;
        }
        return x>0?res:-res;
    }


    public static void main(String [ ] args)
    {
        ReverseInteger test = new ReverseInteger();
        int x = 0;

        System.out.println(test.reverse(x));

    }
}
