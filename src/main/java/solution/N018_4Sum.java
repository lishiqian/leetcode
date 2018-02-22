package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class N018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> resList = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return resList;

        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];

        if(4 * nums[0] > target || 4 * max < target) //太大或太小
            return resList;

        int z;
        for (int i = 0; i < len; i++) {
            z = nums[i];
            if(i > 0 && z == nums[i-1]) //去重复
                continue;
            if(z + 3 * max < target) //太小
                continue;
            if(4 * z > target) //太大
                break;
            if(4 * z == target){ // 刚好合适
                if(i + 3 < len && z == nums[i + 3])
                    resList.add(Arrays.asList(z,z,z,z));
                break;
            }
            threeSum(nums,target-z,i+1,len-1,resList,z);
        }
        return resList;
    }

    public void threeSum(int[] nums,int target,int low,int high,ArrayList<List<Integer>> resList,int z1){
        if(low + 1 >= high)
            return;

        int max = nums[high];
        if(3 * nums[low] > target || 3 * max < target) // 太大或太小
            return;

        int z;
        for (int i = low; i < high-1; i++) {
            z = nums[i];
            if(i > low && z == nums[i - 1]) //去重复
                continue;
            if(z + 2 * max < target) // 太小
                continue;
            if(3 * z > target) // 太大
                break;
            if(3 * z == target) {
                if(i + 1 < high && z == nums[i + 2])
                    resList.add(Arrays.asList(z1,z,z,z));
                break;
            }
            twoSum(nums,target-z,i + 1,high,resList,z1,z);
        }
    }


    public void twoSum(int[] nums,int target,int low,int high,ArrayList<List<Integer>> resList,int z1,int z2){
        if(low >= high) return;
        if(2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int sum,x;
        while (low < high){
            sum = nums[low] + nums[high];
            if(sum == target){
                resList.add(Arrays.asList(z1,z2,nums[low],nums[high]));

                x = nums[low];
                while (++low < high && x == nums[low]);
                x = nums[high];
                while (low < --high && x == nums[high]);
            }
            if(sum < target){
                low++;
            }
            if(sum > target){
                high--;
            }
        }
    }


    @Test
    public void test(){
        List<List<Integer>> lists = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
}
