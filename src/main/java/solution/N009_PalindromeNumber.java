package solution;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

/**
 * 题目大意：
 * 给你一个整数，判断他是否回文
 * 没有太多额外空间
 */
public class N009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int y = 0;
        while (x > y){
            y  = y * 10 + x % 10;
            x /= 10;
        }

        return y == x || x == (y / 10);
    }
}
