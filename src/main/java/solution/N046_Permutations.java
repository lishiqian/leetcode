package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

/**
 * 题目大意：
 * 给你一个去重复的数字集合，返回所有可能的排列组合
 */
public class N046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        permute(nums,0,resList);
        return resList;
    }

    public void permute(int[] nums,int begin,List<List<Integer>> resList){
        if(begin == nums.length){
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            resList.add(list);
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if(i == begin || nums[begin] != nums[i]){
                swap(nums,begin,i);
                permute(nums,begin + 1,resList);
                swap(nums,i,begin);
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
