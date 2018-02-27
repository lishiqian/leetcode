package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

/**
 * 题目大意：
 * 给你一个可能包含重复的集合，返回全部可能的唯一排列
 */
public class N047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
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
            if(i == begin || check(nums,begin,i,nums[i])){
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

    //如果前面有和target相同的数字 交换后没有任何的意义，会存在重复
    public boolean check(int[] nums,int start,int end,int target){
        for (int i = start; i < end; i++) {
            if(nums[i] == target) return false;
        }
        return true;
    }
}
