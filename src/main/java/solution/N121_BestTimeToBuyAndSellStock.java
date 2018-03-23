package solution;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 */

/**
 * 题目大意：
 * 假设你有一个数组，其中i元素是给定股票在第一天的价格。
 *
 * 如果你只允许最多完成一个交易（即买入一个股票，卖出一份股票），设计一个最大利润的算法。
 */
public class N121_BestTimeToBuyAndSellStock {
    //O(n*n)
//    public int maxProfit(int[] prices) {
//        int res = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                res = Math.max(res,prices[j] - prices[i]);
//            }
//        }
//
//        return res;
//    }

    //O(n)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(min > prices[i]){
                min = prices[i];
            }else{
                res = Math.max(res,prices[i] - min);
            }
        }
        return res;
    }
}
