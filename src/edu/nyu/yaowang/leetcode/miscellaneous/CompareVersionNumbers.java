package edu.nyu.yaowang.leetcode.miscellaneous;

/**
 * Created by Yao on 2/6/15.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = v1.length>v2.length? v1.length:v2.length;


        for(int i=0; i<n; i++) {
           int value1 = i<v1.length? Integer.parseInt(v1[i]) : 0;
           int value2 = i<v2.length? Integer.parseInt(v2[i]) : 0;

            if(value1>value2) {
                return 1;
            }

            if(value2>value1) {
                return -1;
            }

        }

        return 0;


    }

}
