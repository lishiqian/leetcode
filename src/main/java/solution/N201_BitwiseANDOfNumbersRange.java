package solution;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * For example, given the range [5, 7], you should return 4.
 */

/**
 * 题目大意 求区间[m,n]中所以数的与运算的值
 * https://blog.csdn.net/u014673347/article/details/46944469
 */
public class N201_BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            count++;
        }

        return m << count;
    }
}
