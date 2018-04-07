package solution;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

import org.junit.Test;

/**
 * 题目大意：
 * 求出在数组中出现超过一半的次数。
 */
public class N169_MajorityElement {
    public int majorityElement(int[] nums) {
        int store = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                count = 1;
                store = nums[i];
                continue;
            }
            if(store == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == store){
                count++;
            }
        }

        if(count >= nums.length / 2)
            return store;
        return -1;
    }

    @Test
    public void test(){
        System.out.println(majorityElement(new int[]{1,2,3,2,4,2,5,2}));
    }
}
