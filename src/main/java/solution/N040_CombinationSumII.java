package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */

/**
 * /**
 * 题目大意：
 * 给你一个数组，求出其和为target的所有组合,一个数在一个组合中只能使用一次
 */

public class N040_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> curList = new LinkedList<Integer>();
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        combination(candidates,target,0,curList,resList);
        return resList;
    }


    public void combination(int[] candidates, int target, int index, LinkedList<Integer> curList, List<List<Integer>> resList) {
        if(target == 0){
            resList.add(new LinkedList<>(curList));
            return;
        }
        if(index >= candidates.length || target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            curList.add(candidates[i]);
            combination(candidates,target-candidates[i],i+1,curList,resList);
            curList.removeLast();
        }
    }
}
