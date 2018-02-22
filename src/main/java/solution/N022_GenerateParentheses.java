package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

/**
 * 题目大意:
 * 给你一个数字n,编写一个函数求出n对小括号的所有合法组合
 */
public class N022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res,"",n,n);
        return res;
    }

    public void backtrack(List<String> res,String s,int left,int right){
        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }

        if(left > 0) backtrack(res,s + '(',left-1,right);
        if(right > left) backtrack(res,s + ')',left,right-1);
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
