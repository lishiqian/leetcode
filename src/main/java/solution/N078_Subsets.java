package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class N078_Subsets {

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
//        List<Integer> subset = new ArrayList<Integer>();
//
//        HashSet<Integer> set = new HashSet<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//        List<Integer> setList = new ArrayList<Integer>(set);
//        combine(subsets,subset,setList,0);
//        return subsets;
//    }
//
//    public void combine(List<List<Integer>> subsets, List<Integer> subset, List<Integer> setList,int begin) {
//        subsets.add(new ArrayList<>(subset));
//        if(begin < setList.size()){
//            for (int i = begin; i < setList.size(); i++) {
//                subset.add(setList.get(i));
//                combine(subsets,subset,setList,i + 1);
//                subset.remove(subset.size()-1);
//            }
//        }
//    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        combine(subsets,subset,nums,0);
        return subsets;
    }

    public void combine(List<List<Integer>> subsets, List<Integer> subset, int[] nums,int begin) {
        subsets.add(new ArrayList<>(subset));
        for (int i = begin; i < nums.length; i++) {
            subset.add(nums[i]);
            combine(subsets,subset,nums,i + 1);
            subset.remove(subset.size()-1);
        }

    }
}
