package solution;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class N120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if(j == i)
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                else if(j == 0)
                    dp[j] = dp[j] + triangle.get(i).get(j);
                else
                    dp[j] = Math.min(dp[j],dp[j-1]) + triangle.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.min(res,dp[i]);
        }
        return res;
    }
}
