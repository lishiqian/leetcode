package solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 * spoilers alert... click to show requirements for atoi.
 */
public class N008_StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            boolean isNegative = false;
            int result = 0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '-'){
                    isNegative = true;
                    continue;
                }else if(str.charAt(i) == '+'){
                    continue;
                }

                result = result * 10 + (str.charAt(i) - '0');
            }
            return isNegative ? -result:result;
        }else{
            return 0;
        }
    }
}
