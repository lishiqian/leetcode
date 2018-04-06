package solution;

/**
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that num[-1] = num[n] = -∞.
 *
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 * click to show spoilers.
 *
 * Note:
 * Your solution should be in logarithmic complexity.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * 题目中已经说明，最左端和最右端元素均无限小，中间元素比两侧都要大，那么本题中一定存在一个峰元素。
 * 所以不管中间有多少波峰，只要找到峰元素，我们只需找到刚刚开始下降而未下降的位置。
 * 采用二分查找，查出这样一个位置即可，我们知道二分查找要比较的是 target 元素，
 * 本题的 target 元素是 mid 的后一个元素，即 nums[mid] 与 nums[mid+1] 进行比较：
 */
public class N162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}
