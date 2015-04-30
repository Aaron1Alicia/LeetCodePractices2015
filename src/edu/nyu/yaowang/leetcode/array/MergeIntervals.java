package edu.nyu.yaowang.leetcode.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Yao on 2/15/15.
 * 先自定义算子，然后sort. 然后扫一遍就行了。
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        if(intervals==null || intervals.size()==0) {
            return intervals;
        }

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return (i1.start - i2.start);
            }
        };

        // sort的目的是确保cur.start>=pre.start
        Collections.sort(intervals, comparator);

        Interval pre = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {

            Interval cur = intervals.get(i);

            if(cur.start>pre.end) {
                pre = cur;
            }
            // 在第一步sort后， cur.start>=pre.start, 如果cur.start<=pre.end,
            // 那么表示两个interval conflict, 开始merge
            else {
                intervals.remove(pre);
                cur.start = Math.min(pre.start, cur.start);
                cur.end = Math.max(cur.end, pre.end);
                pre = cur;
                i--;
            }

        }

        return intervals;

    }


    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
