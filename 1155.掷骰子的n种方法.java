/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 */

// @lc code=start
class NumRollsToTarget {
  public int numRollsToTarget(int n, int k, int target) {
    int[][] dp = new int[n][target + 1];
    for (int i = 0; i <= target; i++) {
      dp[0][i] = 1 <= i && i <= k ? 1 : 0;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= target; j++) {
        for (int m = 1; m <= k; m++) {
          if (j >= m) {
            dp[i][j] += dp[i - 1][j - m];
            dp[i][j] %= 1000000007;
          }
        }
      }
    }
    return dp[n - 1][target];
  }

  public int numRollsToTarget1(int n, int k, int target) {
    int[] dp = new int[target + 1];
    for (int i = 1; i <= target && i <= k; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = target; j >= 0; j--) {
        for (int m = 1; m <= k && m <= j; m++) {
            dp[j] += dp[j - m];
            dp[j] %= 1000000007;
        }
      }
    }
    return dp[target];
  }
}
// @lc code=end
