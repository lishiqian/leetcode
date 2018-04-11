package solution;

import org.junit.Test;

/**
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * [show hint]
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 *
 * Related problem: Reverse Words in a String II
 */
public class N189_RotateArray {
    public void rotate(int[] nums, int k) {
        if(k < 0) return;
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    public void reverse(int[] nums, int begin,int end){
        while (begin < end){
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }

    @Test
    public void test(){
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println("");
    }
}
