package solution;

import org.junit.Test;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class N034_SearchForARange {
//    public int[] searchRange(int[] nums, int target) {
//        int mid = -1;
//        int lo = 0,hi = nums.length - 1;
//        while (lo <= hi){
//            mid = lo + (hi - lo)/2;
//            if(nums[mid] == target)
//                break;
//            else if(nums[mid] < target)
//                lo = mid + 1;
//            else
//                hi = mid - 1;
//        }
//
//        if(mid < 0 || mid >= nums.length || nums[mid] != target)
//            return new int[]{-1,-1};
//
//        int start = mid;
//        int end = mid;
//        while (start >= 0 && nums[start] == nums[mid])
//            start--;
//        while (end < nums.length && nums[end] == nums[mid])
//            end++;
//        return new int[]{start+1,end-1};
//    }

    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums,target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        return new int[]{start,firstGreaterEqual(nums,target+1)-1};
    }

    //二分 返回第一个等于或者大于target的索引
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0,high = A.length;
        while (low < high){
            int mid = low + (high-low)/2;
            if(A[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    @Test
    public void test(){

    }
}
