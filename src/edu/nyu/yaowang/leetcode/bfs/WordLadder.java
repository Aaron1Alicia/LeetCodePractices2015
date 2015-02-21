package edu.nyu.yaowang.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Yao on 2/19/15.
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {

        if(start==null || end==null || start.length()!=end.length()||dict==null ||
                dict.size()==0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        Set<String> visited = new HashSet<String>();
        visited.add(start);

        int lastNum = 1;
        int distance = 1;
        int curNum = 0;
        int n = start.length();

        while(!queue.isEmpty()) {
            String cur =  queue.poll();
            lastNum--;

            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder(cur);
                for(char j='a'; j<='z'; j++) {

                    sb.setCharAt(i, j);
                    String tmp = sb.toString();
                    if(tmp.equals(end)) {
                        return distance+1;
                    }
                    if(dict.contains(tmp) && !visited.contains(tmp)) {

                        visited.add(tmp);
                        queue.add(tmp);
                        curNum++;

                    }

                }
            }

            if(lastNum==0) {
                lastNum = curNum;
                distance++;
                curNum =0;
            }
        }


        return 0;
    }
}
