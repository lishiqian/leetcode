package solution;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 *
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 *
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

/**
 * 题目大意：
 * 爬楼梯，每次只能上一步或者两步，就爬到n位置的方法数
 */
public class N070_ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;

        int f1 = 2;
        int f0 = 1;
        while (n-- > 2){
            f1 = f1 + f0;
            f0 = f1 - f0;
        }

        return f1;
    }
}
