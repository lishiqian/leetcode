package solution;

import org.junit.Test;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output:  321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

/**
 * 题目大意：
 * 整数反转：123变321 -123变-321
 */
public class N007_ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //溢出判断
            if((newResult - tail) / 10 != result) return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(reverse(1534236469));
        System.out.println(-101 % 10);
    }

}
