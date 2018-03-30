package solution;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */

/**
 * 题目大意：
 * 给定词典的情况下，看看原字符串能不能全部成功地被给定的词典分割。
 */
//https://blog.csdn.net/mine_song/article/details/72081998
public class N139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] 表示0-i的字符串能被wordDict分割
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j,i);
                if(dp[j] && wordDict.contains(tmp)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


}
