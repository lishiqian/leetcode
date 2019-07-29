package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class N090_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();

        Arrays.sort(nums);
        combine(result,stack,nums,0);

        return result;
    }

    public void combine(List<List<Integer>> result, Stack<Integer> stack, int[] nums, int begin) {
        result.add(new ArrayList<>(stack));
        Integer prv = null;
        for (int i = begin; i < nums.length; i++) {
            if(prv != null && prv == nums[i])
                continue;
            else
                prv = nums[i];

            stack.push(nums[i]);
            combine(result,stack,nums,i + 1);
            stack.pop();
        }

    }

    @Test
    public void test(){
        List<List<Integer>> result = subsetsWithDup(new int[]{1, 2, 2,3});
        System.out.println(result);
    }
}
