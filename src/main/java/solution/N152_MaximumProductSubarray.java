package solution;

import org.junit.Test;

//https://www.cnblogs.com/bakari/p/4007368.html

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

/**
 * 题目大意：
 * 寻找连续子数组的最大成绩
 */
public class N152_MaximumProductSubarray {
    public int maxProduct(int[] nums){
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max_copy = max;
            max = Math.max(Math.max(max_copy * nums[i],min * nums[i]),nums[i]);
            min = Math.min(Math.min(max_copy * nums[i],min * nums[i]),nums[i]);
            res = Math.max(res,max);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{2,3,-2,4,2}));
    }
}
