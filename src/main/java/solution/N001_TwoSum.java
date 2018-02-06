package solution;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,

 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

/**
 * 题目大致描述：
 * 给你一个整形数组，求两个元素相加的和等于target的数组元素的索引。
 * 你可以假设每个输入都有一个解决方案
 */
public class N001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = null;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    res = new int[]{i,j};
                    break;
                }
            }
        }
        return res;
    }
}
