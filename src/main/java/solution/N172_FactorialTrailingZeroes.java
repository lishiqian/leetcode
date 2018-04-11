package solution;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * 题目大意：
 * 给定一个整数n，返回n!的末尾0的个数，要求对数阶时间复杂度。
 */
public class N172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0){
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
