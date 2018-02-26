package solution;

import org.junit.Test;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class N042_MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length(),m = num2.length();
        int[] pos = new int[m + n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j,p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            if(sb.length() != 0 || pos[i] != 0)
                sb.append(pos[i]);
        }

        return sb.length() == 0 ? "0":sb.toString();
    }

    @Test
    public void test(){
        System.out.println(multiply("100","100"));
    }
}
