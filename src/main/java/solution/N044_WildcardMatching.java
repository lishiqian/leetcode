package solution;

import org.junit.Test;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class N044_WildcardMatching {
//http://shmilyaw-hotmail-com.iteye.com/blog/2154716
    //暴力递归 超时
//    public boolean isMatch(String s, String p) {
//        return isMatch(s,p,0,0);
//    }
//
//    public boolean isMatch(String s,String p,int sIndex,int pIndex){
//        if(pIndex == p.length()) return sIndex == s.length();
//        else if(p.charAt(pIndex) == '*'){
//            while (sIndex <= s.length()){
//                if(isMatch(s,p,sIndex,pIndex + 1))
//                    return true;
//                sIndex++;
//            }
//        }else if(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
//            return isMatch(s,p,sIndex+1,pIndex+1);
//        }
//        return false;
//    }

    //动态规划
    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[m][n];
    }




    @Test
    public void test(){
        System.out.println(isMatch("aa", "a"));
    }
}
