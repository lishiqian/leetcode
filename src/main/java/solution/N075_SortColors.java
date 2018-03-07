package solution;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */

import org.junit.Test;

/**
 * 题目大意：
 * 排序，数组中只包含 0 1 2
 */
public class N075_SortColors {
    public void sortColors(int[] nums) {
        int endIndex = nums.length - 1;
        int startIndex = 0;
        while (startIndex < endIndex){
            while (startIndex < endIndex && nums[endIndex] == 2){
                endIndex--;
            }

            while (startIndex < endIndex){
                if(nums[startIndex] == 2){
                    swap(nums,startIndex,endIndex);
                    break;
                }
                startIndex++;
            }
        }

        startIndex = 0;
        while (startIndex < endIndex) {
            while (startIndex < endIndex && nums[startIndex] == 0) {
                startIndex++;
            }

            while (startIndex < endIndex) {
                if (nums[endIndex] == 0) {
                    swap(nums, startIndex, endIndex);
                    break;
                }
                endIndex--;
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    public void test(){
        int arr[] = new int[]{1,2,0,1,2,0};
        sortColors(arr);
        System.out.println(arr);
    }
}
