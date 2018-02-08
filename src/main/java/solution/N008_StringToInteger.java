package solution;


import org.junit.Test;

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
        if(str.length() == 0) return 0;
        boolean sign = true;
        long ans = 0;
        int index = 0;
        if(str.charAt(0) == '+'){
            sign = true;
            index++;
        }else if(str.charAt(0) == '-'){
            sign = false;
            index++;
        }

        while (index < str.length()){
            if(Character.isDigit(str.codePointAt(index))){
                ans = ans * 10 + (str.codePointAt(index++) - '0');
                if(sign == true && ans > Integer.MAX_VALUE ){
                    return Integer.MAX_VALUE ;
                }else if(sign == false && -ans < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }

        return (int)(sign == true ? ans : -ans);
    }

    @Test
    public void test(){
        System.out.println(myAtoi("2147483647"));
    }
}
