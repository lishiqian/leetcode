package solution;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 */

import org.junit.Test;

/**
 * 题目大意：
 * 在一个m * n的网格里，一个机器人想从左上角移动到右下角，每一步只能往右走或者网下走，求出其中可能的唯一的路径条数
 */
public class N062_UniquePaths {
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = 1;
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
//            }
//        }
//
//        return dp[m-1][n-1];
//    }


    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(i == 0){
                    dp[j] = 1;
                }else{
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }

        return dp[n-1];
    }

    @Test
    public void test(){
        System.out.println(uniquePaths(3,7));
    }
}
