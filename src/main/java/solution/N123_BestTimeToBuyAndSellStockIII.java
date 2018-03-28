package solution;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

import org.junit.Test;

/**
 * 题目大意：
 * 同样是买股票，但是一天只可以交易两次
 * https://blog.csdn.net/u012501459/article/details/46514309
 */
public class N123_BestTimeToBuyAndSellStockIII {
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length == 0 || prices.length == 1)
//            return 0;
//
//        int[] ascAndMax = new int[prices.length];
//        int minPrice = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            minPrice = Math.min(minPrice,prices[i]);
//            ascAndMax[i] = Math.max(ascAndMax[i-1],prices[i] - minPrice);
//        }
//
//        int[] descAndMax = new int[prices.length];
//        int maxPrice = prices[prices.length-1];
//        for (int i = prices.length-2; i >= 0; i--) {
//            maxPrice = Math.max(maxPrice,prices[i]);
//            descAndMax[i] = Math.max(descAndMax[i + 1],maxPrice - prices[i]);
//        }
//
//        int res = 0;
//        for (int i = 0; i < prices.length; i++) {
//            res = Math.max(res,ascAndMax[i] + descAndMax[i]);
//        }
//
//        return res;
//    }

    public int maxProfit(int[] prices){
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            sell2 = Math.max(sell2,buy2 + prices[i]);
            buy2 = Math.max(buy2,sell1 - prices[i]);
            sell1 = Math.max(sell1,buy1 + prices[i]);
            buy1 = Math.max(buy1,-prices[i]);
        }
        return sell2;
    }

    @Test
    public void test(){
        maxProfit(new int[]{1,2});
    }
}

