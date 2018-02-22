package solution;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */

/**
 * 题目大意:
 * 给你一个排序的数组，删除重复的副本并返回新的数组的长度，在原数组上修改
 */
public class N026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int slowIndex = 0;
        int fastIndex = 0;
        while (fastIndex < nums.length){
            count++;
            nums[slowIndex] = nums[fastIndex++];
            while (fastIndex < nums.length && nums[slowIndex] == nums[fastIndex]) fastIndex++;
            slowIndex++;
        }
        return count;
    }

    public void test(){
        removeDuplicates(new int[]{1,2,2});
    }
}
