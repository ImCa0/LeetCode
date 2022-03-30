/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int INF = 0x3f3f3f3f;
    int n = coins.length;
    int[] dp = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      if (i % coins[0] == 0) {
        dp[i] = i / coins[0];
      } else {
        dp[i] = INF;
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= amount; j++) {
        int no = dp[j];
        int yes = j >= coins[i] ? dp[j - coins[i]] + 1 : INF;
        dp[j] = Math.min(no, yes);
      }
    }
    return dp[amount] == INF ? -1 : dp[amount];
  }
}
// @lc code=end
