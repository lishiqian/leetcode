package solution;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 */

/**
 * 给你一个未排序的数组，找出数组中缺失的第一个整数，时间复杂度O(n),空间复杂度O(1)
 */
public class N041_FirstMissingPositive {

    //主要思想是将A[i] 换到索引为 A[i]-1 的位置上
    //让A[0]=1,A[1]=2,A[2]=3
    //这样就方便找出缺失的整数
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if(nums[i] < 1 || nums[i] >= nums.length || nums[i] == i+1) i++;
            else if(nums[nums[i] - 1] != nums[i]) swap(nums,i,nums[i] - 1);
            else i++;
        }

        i = 0;
        while (i < nums.length && nums[i] == i+1) i++;
        return i+1;
    }


    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
