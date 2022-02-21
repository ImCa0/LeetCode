/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class MaxProfit {
  public int maxProfit(int[] prices) {
    int days = prices.length;
    int[] max = new int[days];
    max[days - 1] = prices[days - 1];
    for (int i = days - 2; i >= 0; i--) {
      max[i] = Math.max(prices[i], max[i + 1]);
    }
    int maxProfit = 0;
    for (int i = 0; i < max.length; i++) {
      maxProfit = Math.max(maxProfit, max[i] - prices[i]);
    }
    return maxProfit;
  }

  // 动态求最小值
  // 上述方法为动态求最大值
  public int maxProfit2(int[] prices) {
    int size = prices.length;
    int min = prices[0];
    int profit = 0;
    for (int i = 1; i < size; i++) {
        min = Math.min(min, prices[i]);
        profit = Math.max(profit, prices[i] - min);
    }
    return profit;
}
}
// @lc code=end
