package solution;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class N132_PalindromePartitioningII {
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[len + 1];
        boolean[][] isPalindrome = new boolean[len + 1][len + 1];
        for (int i = 0; i < len; i ++) {
            dp[i] = len - i - 1;
            isPalindrome[i][i] = true;
        }
        dp[len] = -1;
        for (int i = len - 1; i >= 0; i --) {
            for (int j = i; j < len; j ++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                    isPalindrome[i][j] = true;
                }
            }
        }
        return dp[0];
    }
}
