package solution;

import org.junit.Test;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class N032_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                if(stack.isEmpty())
                    left = i;
                else{
                    stack.pop();
                    if(stack.isEmpty())
                        maxLen = Math.max(maxLen,i - left);
                    else
                        maxLen = Math.max(maxLen,i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    @Test
    public void test(){
        System.out.println(longestValidParentheses(")))"));
    }
}
