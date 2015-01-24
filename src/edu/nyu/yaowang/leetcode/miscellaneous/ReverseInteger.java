package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 1/22/15.
 * 本题的要点一个是注意处理负数的情况，第二个是提前检测overflow, 如果overflow, 那么返回0
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNagetive = false;
        if(x<0) {
           isNagetive = true;
        }
        x = Math.abs(x);
        int ret = 0;

        while(x>0) {
            if(Math.abs(ret) > Integer.MAX_VALUE / 10)
            {
                return 0;
            }
            int tmp = x%10;
            x = x/10;
            ret = ret*10+tmp;
        }

        if(isNagetive) {
           ret = 0-ret;
        }
        return ret;
    }


    public static void main(String [ ] args)
    {
        ReverseInteger test = new ReverseInteger();
        int x = 0;

        System.out.println(test.reverse(x));

    }
}
