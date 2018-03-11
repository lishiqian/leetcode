package solution;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
//https://www.cnblogs.com/ganganloveu/p/4148303.html
public class N084_LargestRectangleInHistogram {
    //动态规划 n^2 超时
//    public int largestRectangleArea(int[] heights) {
//        int dp[][] = new int[heights.length][heights.length];
//
//        for (int i = 0; i < heights.length; i++) {
//            dp[i][i] = heights[i];
//        }
//
//        for (int i = 0; i < heights.length-1; i++) {
//            for (int j = i+1; j < heights.length; j++) {
//                dp[i][j] = Math.max(Math.min(dp[i][j-1],heights[j]),Math.min(dp[i + 1][j],heights[i]));
//            }
//        }
//
//
//        int result = 0;
//        for (int i = 0; i < heights.length; i++) {
//            for (int j = i; j < heights.length; j++) {
//                result = Math.max(result,dp[i][j] * (j - i + 1));
//            }
//        }
//
//        return result;
//    }


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
