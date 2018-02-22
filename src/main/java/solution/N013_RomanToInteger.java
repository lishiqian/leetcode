package solution;

import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * 题目大意:
 * 给你一个罗马数字，转换成整数，输入范围保证在1到3999之间
 */
public class N013_RomanToInteger {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int sum = getRomanInt(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >= 0; i--) {
            if(getRomanInt(s.charAt(i))<getRomanInt(s.charAt(i+1))){
                sum -= getRomanInt(s.charAt(i));
            }else{
                sum += getRomanInt(s.charAt(i));
            }
        }
        return sum;
    }

    public int getRomanInt(char c){
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        if(c == 'M') return 1000;
        return 0;
    }


    @Test
    public void test(){
        System.out.println(romanToInt("VD"));
    }
}
