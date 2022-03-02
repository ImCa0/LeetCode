/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class FindPaths {
  int mod = 1000000007;

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    int[][][] dp = new int[m][n][maxMove + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0)
          add(i, j, maxMove, dp);
        if (i == m - 1)
          add(i, j, maxMove, dp);
        if (j == 0)
          add(i, j, maxMove, dp);
        if (j == n - 1)
          add(i, j, maxMove, dp);
      }
    }
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int currMove = 1; currMove <= maxMove; currMove++) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
              dp[i][j][currMove] += dp[x][y][currMove - 1];
              dp[i][j][currMove] %= mod;
            }
          }
        }
      }
    }
    return dp[startRow][startColumn][maxMove];
  }

  void add(int x, int y, int maxMove, int[][][] dp) {
    for (int i = 1; i <= maxMove; i++) {
      dp[x][y][i] += 1;
    }
  }
}
// @lc code=end
