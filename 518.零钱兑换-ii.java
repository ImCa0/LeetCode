/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Change {
  public int change(int amount, int[] coins) {
    int n = coins.length;
    int[] dp = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      dp[i] = i % coins[0] == 0 ? 1 : 0;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= amount; j++) {
        int no = dp[j];
        int yes = j >= coins[i] ? dp[j - coins[i]] : 0;
        dp[j] = no + yes;
      }
    }
    return dp[amount];
  }
}
// @lc code=end
