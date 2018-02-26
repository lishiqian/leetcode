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
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,s.length()-1,p.length()-1);
    }

    public boolean isMatch(String s, String p,int sIndex,int pIndex){
        if(pIndex == -1) return sIndex == -1;

        if(p.charAt(pIndex) == '*'){
            if(sIndex > -1 && (p.charAt(pIndex-1) == '.' || p.charAt(pIndex-1) == s.charAt(sIndex)))
                if(isMatch(s,p,sIndex-1,pIndex)) return true;
            return isMatch(s,p,sIndex,pIndex-1);
        }
        if(p.charAt(pIndex) == '.' || s.charAt(sIndex)==p.charAt(pIndex)){
            return isMatch(s,p,sIndex - 1, pIndex - 1);
        }
        return false;
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
