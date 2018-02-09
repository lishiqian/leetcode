package solution;

import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class N013_RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int romanValue = getRomanInt(s.charAt(i));
            if(i == 0) {
                sum += romanValue;
                continue;
            }
            if(sum >= romanValue) sum = sum + romanValue;
            else sum = romanValue - sum;
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
        System.out.println(romanToInt(""));
    }
}
