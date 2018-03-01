package solution;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

/**
 * 题目大意：
 * 在集合中插入一个区间后，合并重叠区间区间
 */
public class N057_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        boolean isInsert = false;
        for (int i = 0; i < intervals.size(); i++) {
            if(newInterval.start <= intervals.get(i).start){
                intervals.add(i,newInterval);
                isInsert = true;
                break;
            }
        }
        if(!isInsert) intervals.add(newInterval);

        List<Interval> resList = new ArrayList<Interval>();
        Interval current = null;
        for (Interval inter:intervals) {
            if(current == null || current.end < inter.start){
                current = inter;
                resList.add(inter);
            }else{
                current.end = Math.max(current.end,inter.end);
            }
        }
        return resList;
    }
}
