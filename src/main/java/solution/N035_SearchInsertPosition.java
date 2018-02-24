package solution;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */

/**
 * 题目大意：
 * 给你一个排序数组和一个值，返回在数组中插入target的索引，你可以认为数组中没有相同的值。
 */
public class N035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length;
        while (low < high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
