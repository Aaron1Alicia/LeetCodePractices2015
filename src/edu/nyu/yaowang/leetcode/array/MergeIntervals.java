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

        Comparator<Interval> comparator =
                new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start - o2.start;
                    }
                };
        Collections.sort(intervals, comparator);

        for(int i=1; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);
            Interval pre = intervals.get(i-1);

            if(cur.start<=pre.end && cur.end>=pre.start) {
                cur.start = Math.min(cur.start, pre.start);
                cur.end = Math.max(cur.end, pre.end);
                intervals.remove(i-1);
                i--;
            } else if(cur.end < pre.start) {
                intervals.remove(i);
                intervals.add(i-1, cur);

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
