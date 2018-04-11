package solution;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class N179_LargestNumber {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if((nums[i] + "" + nums[j]).compareTo(nums[j] + "" + nums[i]) < 0){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        if(nums[0] == 0) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }

        return  sb.toString();
    }
}
