package solution;

import org.junit.Test;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */

/**
 * 题目大意:
 * 求一个字符串的最长回文子串，字符串最大长度为1000;
 * 如存在多个，返回任意一个即可
 */
public class N005_LongestPalindromicSubstring {
    /**
    //暴力枚举超时
    public String longestPalindrome(String s) {
        return longestPalindrome(s,0,s.length()-1);
    }

    public String longestPalindrome(String s,int start,int end) {
        if(isPalindrome(s,start,end)) return s.substring(start,end+1);
        String sub1 = longestPalindrome(s,start,end-1);
        String sub2 = longestPalindrome(s,start+1,end);
        return sub1.length() >= sub2.length() ? sub1:sub2;
    }

    public boolean isPalindrome(String s,int start,int end){
        while (start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }*/


    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        String res = null;
        int maxLen = 0;
        int curLen = 0;

        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //处理奇数回文子串
            begin = i-1;
            end = i + 1;
            while (begin >= 0 && end < s.length()){
                if(s.charAt(begin) == s.charAt(end)){
                    begin--;
                    end++;
                }else{
                    break;
                }
            }

            curLen = end - begin - 1;
            if(curLen > maxLen){
                res = s.substring(begin + 1,end);
                maxLen = curLen;
            }

            //处理偶数回文子串
            begin = i;
            end = i + 1;
            while (begin >= 0 && end < s.length()){
                if(s.charAt(begin) == s.charAt(end)){
                    begin--;
                    end++;
                }else{
                    break;
                }
            }

            curLen = end - begin - 1;
            if(curLen > maxLen){
                res = s.substring(begin + 1,end);
                maxLen = curLen;
            }
        }

        return res;
    }




    @Test
    public void test(){
//        System.out.println(longestPalindrome("aba"));
//        System.out.println(longestPalindrome("cbba"));
//        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bbbbbb"));
    }
}
