package solution;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 */

import org.junit.Test;

/**
 * 题目大意:
 * 在一个旋转后的排序数组中查找target
 */
public class N033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0,hi = nums.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return mid;
            else if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }else {
                if(nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            System.out.printf("low:%d,high:%d\n",lo,hi);
        }


        return nums[lo] == target ? lo : -1;
    }


    @Test
    public void test(){
        System.out.println(search(new int[]{4,5,6,7,8,9,0,1,2,3,4},0));
    }
}
