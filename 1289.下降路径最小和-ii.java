/*
 * @lc app=leetcode.cn id=1289 lang=java
 *
 * [1289] 下降路径最小和  II
 */

// @lc code=start
class MinFallingPathSum2 {
  public int minFallingPathSum(int[][] grid) {
    int n = grid.length;
    int dp[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          dp[i][j] = grid[i][j];
        } else {
          int min = Integer.MAX_VALUE;
          for (int k = 0; k < n; k++) {
            if (k != j) {
              min = Math.min(min, dp[i - 1][k]);
            }
          }
          dp[i][j] = min + grid[i][j];
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      min = Math.min(min, dp[n - 1][i]);
    }
    return min;
  }
}
// @lc code=end
