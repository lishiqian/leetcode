package solution;

import org.junit.Test;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases.
 */
public class N168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            n--;
            int mod = n % 26;
            sb.append((char) (mod + 'A'));
            n /= 26;
        }

        sb.reverse();
        return sb.toString();
    }

    @Test
    public void test(){

    }
}
