package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */


/**
 * 给你一个整数数组，求出其中三个数相加等于0的所有数
 */
public class N015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int sum = 0 - nums[i];
                int low = i + 1, high = nums.length - 1;
                while (low < high){
                    if(nums[low] + nums[high] == sum){
                        resultList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] < sum){
                        low ++;
                    }else high--;
                }
            }
        }
        return resultList;
    }
}
