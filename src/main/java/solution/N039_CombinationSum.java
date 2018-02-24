package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */

/**
 * 题目大意：
 * 给你一个数组，求出其和为target的所有组合,一个数可以使用多次
 */
public class N039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> curList = new LinkedList<Integer>();
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        combination(candidates,target,0,curList,resList);
        return resList;
    }

//    public void combination(int[] candidates, int target,int index,LinkedList<Integer> curList,List<List<Integer>> resList) {
//        if(target == 0){
//            resList.add(new LinkedList<>(curList));
//            return;
//        }
//        if(index >= candidates.length || target < 0) return;
//
//        curList.add(candidates[index]);
//        combination(candidates,target-candidates[index],index,curList,resList);
//        curList.removeLast();
//        combination(candidates,target,index + 1,curList,resList);
//    }

    public void combination(int[] candidates, int target,int index,LinkedList<Integer> curList,List<List<Integer>> resList) {
        if(target == 0){
            resList.add(new LinkedList<>(curList));
            return;
        }
        if(index >= candidates.length || target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            curList.add(candidates[i]);
            combination(candidates,target-candidates[i],i,curList,resList);
            curList.removeLast();
        }
    }

    @Test
    public  void test() {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
