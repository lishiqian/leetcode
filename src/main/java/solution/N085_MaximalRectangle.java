package solution;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 */
public class N085_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == 0)
                    dp[i][j] = matrix[i][j] - '0';
                else
                    dp[i][j] = (matrix[i][j] == '0' ? 0 : dp[i-1][j] + 1);
            }
            result = Math.max(result,largestRectangleArea(dp[i]));
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[i] >= stack.peek())
                stack.push(heights[i]);
            else {
                int count = 0;
                while (!stack.isEmpty() && heights[i] < stack.peek()){
                    count++;
                    ret = Math.max(ret,stack.peek() * count);
                    stack.pop();
                }

                while (count-- > 0)
                    stack.push(heights[i]);
                stack.push(heights[i]);
            }
        }

        int count = 0;
        while (!stack.isEmpty()){
            count++;
            ret = Math.max(ret,stack.peek() * count);
            stack.pop();
        }
        return ret;
    }
}
