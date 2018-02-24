package solution;

import org.junit.Test;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */

/**
 * 思路：题意实在太难理解了，尤其是英文又不好，只能参看下别人的资料，理解下规则。
 * 终于理解，题意是:
 * n=1时输出字符串1；
 * n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；
 * n=3时，由于上次字符是11，有2个1，所以输出21；
 * n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。
 * 依次类推，写个countAndSay(n)函数返回字符串。
 */
public class N038_CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        String str = countAndSay(n-1) + '*'; //加个*是为了方便尾部统一处理
        int count = 1;
        String s = "";

        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1))
                count++;
            else{
                s = s + count + str.charAt(i);
                count = 1;
            }
        }

        return s;
    }

    @Test
    public void test(){
        System.out.println(countAndSay(5));
    }
}
