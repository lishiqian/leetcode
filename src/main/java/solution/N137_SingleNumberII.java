package solution;

/**
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

import org.junit.Test;

/**
 * 题目大意：
 * 一个数字中其他数字都出现三次，只有一个出现一次,找出这个出现一次的数字
 */
//https://www.cnblogs.com/yanliang12138/p/4536189.html
public class N137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            int mark = 1 << i;

            for (int j = 0; j < nums.length; j++) {
                if((nums[j] & mark) != 0){
                    count++;
                }
            }

            if(count % 3 != 0)
                res |= mark;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(singleNumber(new int[]{2,2,2,3}));
    }
}
