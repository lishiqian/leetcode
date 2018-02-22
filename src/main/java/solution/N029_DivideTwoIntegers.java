package solution;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 */

import org.junit.Test;

/**
 * 题目大意:
 * 在不使用乘法、除法、取模运算的前提下计算两个数相除。
 */
public class N029_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        boolean sign = (dividend < 0) == (divisor < 0);

        long m = Math.abs((long)dividend),n = Math.abs((long)divisor);
        int res = 0;
        while (m >= n){
            long t = n, p = 1;
            while (m >= (t << 1)){
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        return sign ? res:-res;
    }

    @Test
    public void test(){
        System.out.println(divide(-2147483648,2));
        System.out.println(divide(7,2));
    }
}
