package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * 题目大意:
 * 给定一个整数数组，找出其中三个之和最接近target的三个数的和的值
 */
public class N016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDistance = Integer.MAX_VALUE;
        int resSum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int distance = Math.abs(target - sum);
                    if(sum == target){
                        return target;
                    }
                    if(distance <= minDistance){
                        minDistance = distance;
                        resSum = sum;
                    }
                }
            }
        }
        return resSum;
    }

    @Test
    public void test(){
        //System.out.println(threeSumClosest(new int[]{0,1,2},0));
        System.out.println(threeSumClosest(new int[]{1,1,1,0},-100));
    }
}
