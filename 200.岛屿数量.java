/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class NumIslands {
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  void dfs(char[][] grid, int r, int c) {
    if (!isArea(grid, r, c)) {
      return;
    }
    if (grid[r][c] != '1') {
      return;
    }
    grid[r][c] = '2';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }

  public boolean isArea(char[][] grid, int r, int c) {
    return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
  }
}
// @lc code=end
