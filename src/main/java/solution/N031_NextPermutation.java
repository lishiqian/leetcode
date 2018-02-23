package solution;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

import org.junit.Test;

/**
 * 题目大意:
 * 实现下一个排列，它将数字重新排列成字典的下一个更大的数字排列。
 * 如果这样的安排是不可能的，那么它必须重新排列它，作为最低可能的顺序(例如，按升序排序)。
 * 替换必须是就地的，不要分配额外的内存。
 * 这里有一些例子。输入在左列，其相应的输出在右列。
 */
public class N031_NextPermutation {

    //参考字符串的非递归求全排列
    public void nextPermutation(int[] nums) {
        int pos = nums.length-2;
        while (pos >= 0 && nums[pos] >= nums[pos+1]){
            pos--;
        }

        if(pos == -1){
            reverse(nums,0,nums.length-1);
            return;
        }

        for (int i = nums.length-1; i > pos; i--) {
            if(nums[i] > nums[pos]){
                swap(nums,pos,i);
                reverse(nums,pos+1,nums.length-1);
                break;
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void reverse(int[] nums,int s,int e){
        while (s < e){
            swap(nums,s,e);
            s++;
            e--;
        }
    }

    @Test
    public void test(){
        int[] arr = new int[]{1,2,3,4,5};
        nextPermutation(arr);
        nextPermutation(arr);
        nextPermutation(arr);
        nextPermutation(arr);
        nextPermutation(arr);
        nextPermutation(arr);
    }
}
