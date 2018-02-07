package solution;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import org.junit.Test;

import java.util.HashMap;

/**
 * 题目大意:
 * 给你一个字符串，早到他的最长子串的长度，子串里面的字符不能重复
 * 注意区分子串和子序列
 */
public class N003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int maxSubStrLen = 0;
        int teampSubStrLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                teampSubStrLen = i - start;
                maxSubStrLen = Math.max(maxSubStrLen,teampSubStrLen);
                start = Math.max(start, map.get(c)+1);
            }
            map.put(c, i);
        }
        maxSubStrLen = Math.max(maxSubStrLen,s.length()-start);
        return maxSubStrLen;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abc"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("cabcde"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
