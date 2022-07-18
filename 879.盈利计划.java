/*
 * @lc app=leetcode.cn id=879 lang=java
 *
 * [879] 盈利计划
 */

// @lc code=start
class Solution {
  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    int len = group.length;
    int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
    for (int i = 0; i <= n; i++) {
      dp[0][i][0] = 1;
    }
    for (int k = 1; k <= len; k++) {
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= minProfit; j++) {
          dp[k][i][j] = dp[k - 1][i][j];
          if (i - group[k - 1] >= 0) {
            dp[k][i][j] += dp[k - 1][i - group[k - 1]][j - profit[k - 1] >= 0 ? j - profit[k - 1] : 0];
            dp[k][i][j] %= 1000000007;
          }
        }
      }
    }
    return dp[len][n][minProfit];
  }
}
// @lc code=end
