package solution;

import org.junit.Test;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class N006_ZigZagConversion {
    //模拟过程运行一遍
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int index = 0;
        while (index < s.length()){
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sb[i].append(s.charAt(index++));
            }
            for (int i = numRows-2; i >= 1 && index < s.length(); i--) {
                sb[i].append(s.charAt(index++));
            }
        }

        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < sb.length; i++) {
            resSb.append(sb[i]);
        }
        return resSb.toString();
    }

    @Test
    public void test(){
        System.out.println(convert("QWETETETSFGS",3));
    }
}
