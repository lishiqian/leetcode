package solution;

import org.junit.Test;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 */

/**
 * 给定一组非负整数，您最初定位于数组的第一个索引。
 * 数组中的每个元素都表示您在该位置上的最大跳跃长度。
 * 你的目标是在最小的跳跃点到达最后一个索引。
 * 例如:
 * 给定数组A=2,3,1,1,4
 * 到达最后一个索引的最小值是2。(从索引0跳到1，然后3步到最后一个索引。)
 * 注意:
 * 你可以假设你总能到达最后一个索引。
 */
public class N045_JumpGameII {

    //动态规划 超时
    //dp[j]表示到索引j需要跳的最小次数
//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//
//        for (int i = 1; i < nums.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                if(j + nums[j] >= i){
//                    min = Math.min(min,dp[j]);
//                }
//            }
//            dp[i] = min + 1;
//        }
//        return dp[nums.length - 1];
//    }

    // 贪心算法 寻找前面能到终点的值，让后让这个位置变成终点，循环直到终点变为0
    // 例如:A = [2,2,2,2,3,1,1,4]，跳的次数count = 0,终点dest = 7 (A.length - 1)
    // 第一步,能够跳到 dest = 7 的位置有 4,6  选最小的 dest = 4,count = 1
    // 第二步,能够跳到 dest = 4 的位置有 3,2  选最小的 dest = 2,count = 2
    // 第二步,能够跳到 dest = 2 的位置有 0,1  选最小的 dest = 0,count = 3
    // 因为dest = 0,循环结束，跳的最小次数为 count = 3
    public int jump(int[] nums) {
        int count = 0;

        int dest = nums.length - 1;

        while (dest != 0){
            for (int i = 0; i < dest; i++) {
                if(nums[i] + i >= dest){
                    count++;
                    dest = i;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(jump(new int[]{1,2,3}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
