package solution;

import org.junit.Test;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

/**
 * 题目大意:
 * 给你一个只包含括号的字符串，判断括号是否合法
 */
public class N020_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty())
                    return false;
                else if(getLeftParentheses(ch) == stack.peek())
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public char getLeftParentheses(char ch){
        if(ch == ')') return '(';
        else if(ch == ']') return '[';
        else if(ch == '}') return '{';
        return '\0';
    }

    @Test
    public void test(){
        System.out.println(isValid("()"));
    }
}
