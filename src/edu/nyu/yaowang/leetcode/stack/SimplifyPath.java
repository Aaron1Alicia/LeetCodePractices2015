package edu.nyu.yaowang.leetcode.stack;

import java.util.LinkedList;

/**
 * Created by Yao on 2/6/15.
 * 注意...这种corner case, 真的是很tricky
 * Split会Split出空字符串，然后就是String的比较要用equals方法
 *
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> sb = new LinkedList<String>();

        for(int i=0; i<paths.length; i++) {
            if(!paths[i].equals("")) {
                if(paths[i].equals(".")) {
                    continue;
                } else if(paths[i].equals("..")) {
                    if(sb.size()==0) {
                        continue;
                    }
                    sb.removeLast();
                } else {
                    sb.add(paths[i]);
                }

            }

        }

        System.out.println(sb.size());

        for(String s: sb) {
            System.out.println(s);
        }

        StringBuilder ret = new StringBuilder();
        ret.append("/");

        for(int i=0; i<sb.size();i++) {
            ret.append(sb.get(i));
            ret.append("/");
        }

        if(ret.length()>1) {
            ret.deleteCharAt(ret.length()-1);
        }

        return ret.toString();
    }


    public static void main(String[] args) {

        SimplifyPath simlifyPath = new SimplifyPath();
        //String test = "/a/./b/../../c/";
        String test = "../";
        String[] paths = test.split("\\.");
        System.out.println(paths.length);


    }
}
