/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class FindPaths {
  int mod = 1000000007;
  int N, max;
  int[][] dp;

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    N = n;
    max = maxMove;
    dp = new int[m * n][maxMove + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          add(i, j);
        }
        if (i == m - 1) {
          add(i, j);
        }
        if (j == 0) {
          add(i, j);
        }
        if (j == n - 1) {
          add(i, j);
        }
      }
    }
    int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 0, -1 }, { 0, 1 } };
    for (int move = 1; move <= maxMove; move++) {
      for (int i = 0; i < m * n; i++) {
        for (int[] dir : dirs) {
          int x = parseIndex(i)[0] + dir[0];
          int y = parseIndex(i)[1] + dir[1];
          if (x >= 0 && x < m && y >= 0 && y < n) {
            int index = getIndex(x, y);
            dp[i][move] += dp[index][move - 1];
            dp[i][move] %= mod;
          }
        }
      }
    }
    return dp[getIndex(startRow, startColumn)][maxMove];
  }

  void add(int x, int y) {
    int index = getIndex(x, y);
    for (int i = 1; i <= max; i++) {
      dp[index][i] += 1;
    }
  }

  int getIndex(int x, int y) {
    return x * N + y;
  }

  int[] parseIndex(int idx) {
    return new int[] { idx / N, idx % N };
  }
}
// @lc code=end
