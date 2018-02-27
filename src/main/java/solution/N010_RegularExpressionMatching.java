package solution;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class N010_RegularExpressionMatching {

    //https://www.jianshu.com/p/b591b74008d0
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    if(i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j-2) != '.'))
                        dp[i][j] = dp[i][j-2]; //这个字符不出现 aab -> c*aab = true
                    else
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j - 2];
                }else{
                    dp[i][j] = false; //可以不写 默认为false
                }

            }
        }
        return dp[m][n];
    }



    @Test
    public void test(){
        //System.out.println(isMatch("aa","a."));
        System.out.println(isMatch("aaa","a.*"));
        System.out.println(isMatch("aaa","a*"));
        System.out.println(isMatch("aaa",".*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("aab","a"));
    }
}
