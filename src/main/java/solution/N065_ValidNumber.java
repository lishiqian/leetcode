package solution;

import org.junit.Test;

/**
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 */

/**
 * 题目大意：
 * 给你一个字符串，判断是不是整数
 */
public class N065_ValidNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean afertNumberE = true;

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                numberSeen = true;
                if(eSeen) afertNumberE = true;
            }else if(s.charAt(i) == '.'){
                if(pointSeen || eSeen){
                    return false;
                }
                pointSeen = true;
            }else if(s.charAt(i) == 'e'){
                if(!numberSeen || eSeen){
                    return false;
                }
                eSeen = true;
                afertNumberE = false;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }

        return s.length() != 0 && afertNumberE && numberSeen;
    }

    @Test
    public void test(){
        System.out.println(isNumber(".1"));
    }
}
