package solution;

import java.util.ArrayList;
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
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0);
                    ArrayList<Integer> resultItem = new ArrayList<Integer>(3);
                    resultItem.add(nums[i]);
                    resultItem.add(nums[j]);
                    resultItem.add(nums[k]);
                    resultList.add(resultItem);
                }
            }
        }
        return resultList;
    }
}
