package edu.nyu.yaowang.leetcode.array;

import java.util.List;

/**
 * Created by Yao on 2/15/15.
 */
public class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if(newInterval==null) {
            return intervals;
        }

        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval cur;
        // i定义在外面，方便记录插入的位置, 这个code写的很犀利。
        int i=0;

        for(; i<intervals.size(); i++) {
            cur = intervals.get(i);

            if(cur.start > newInterval.end) {
                break;
            } else if(cur.end < newInterval.start) {
                continue;
            } else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
                intervals.remove(i);
                //这个i--很重要
                i--;
            }

        }

        intervals.add(i, newInterval);
        return intervals;
    }

     private class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
     }
}
