/*
 * @lc app=leetcode.cn id=1219 lang=java
 *
 * [1219] 黄金矿工
 */

// @lc code=start
class GetMaximumGold {
  int[][] grid;
  int m;
  int n;
  boolean[][] visited;

  public int getMaximumGold(int[][] grid) {
    int res = 0;
    this.grid = grid;
    this.m = grid.length;
    this.n = grid[0].length;
    this.visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] != 0) {
          visited[i][j] = true;
          res = Math.max(res, dfs(i, j));
          visited[i][j] = false;
        }
      }
    }
    return res;
  }

  int dfs(int x, int y) {
    int sum = grid[x][y];
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int[] dir : dirs) {
      int nx = x + dir[0];
      int ny = y + dir[1];
      if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
        continue;
      }
      if (grid[nx][ny] == 0) {
        continue;
      }
      if (visited[nx][ny] == true) {
        continue;
      }
      visited[nx][ny] = true;
      sum = Math.max(sum, grid[x][y] + dfs(nx, ny));
      visited[nx][ny] = false;
    }
    return sum;
  }
}
// @lc code=end
