package solution;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

import common.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 题目大意：
 * 给你一些区间，合并重叠的区间
 */
public class N056_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> resList = new ArrayList<Interval>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval curInterval = null;
        for (Interval interval : intervals) {
            if(curInterval == null || curInterval.end < interval.start){
                resList.add(interval);
                curInterval = interval;
            }else {
                curInterval.end = Math.max(curInterval.end,interval.end);
            }
        }
        return resList;
    }



    @Test
    public void test(){
    }

}
