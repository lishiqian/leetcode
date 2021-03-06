package solution;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 */

/**
 * 题目大意：
 * 给定排序后的数组NUM，删除重复的位置，以便重复出现最多两次，并返回新长度。
 * 不要为另一个数组分配额外的空间，必须通过用O（1）额外的内存修改输入数组来完成这一点。
 */
public class N080_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;

        int len = nums.length;

        int t = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(t == nums[i]){
                count++;
                if(count > 2){
                     remove(nums,i,len);
                     count--;
                     len--;
                     i--;
                }
            }else{
                count = 1;
                t = nums[i];
            }
        }

        return len;
    }

    public void remove(int[] nums,int index,int len){
        for (int i = index; i < len - 1; i++) {
            nums[i] = nums[i+1];
        }
    }


}
