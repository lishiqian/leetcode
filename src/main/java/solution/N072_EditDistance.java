package solution;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */

/**
 * 给定两个单词word1和word2，找到将word1转换为word2所需的最小步骤。（每个操作都被计算为1步。）
 * 你有下列3个操作：
 * 插入一个字符
 * b)删除一个字符
 * c)替换字符
 */
public class N072_EditDistance {
     public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
         for (int i = 1; i <= m; i++) {
             dp[i][0] = dp[i - 1][0] + 1;
         }

         for (int i = 0; i <= n; i++) {
             dp[0][i] = dp[0][i - 1] + 1;
         }

         for (int i = 1; i <= m; i++) {
             for (int j = 1; j <= n; j++) {
                 if(word1.charAt(i-1) == word2.charAt(j - 1)){
                     dp[i][j] = dp[i-1][j-1];
                 }else{
                     //dp[i-1][j] 插入字符
                     //dp[i][j-1] 删除字符
                     //dp[i-1][j-1] 字符替换
                     dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                 }
             }
         }

         return dp[m][n];
     }
}
