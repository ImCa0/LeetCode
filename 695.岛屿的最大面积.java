/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, dfs(grid, i, j));
        }
      }
    }
    return max;
  }

  int dfs(int[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
      return 0;
    }
    if (grid[r][c] != 1) {
      return 0;
    }
    grid[r][c] = 2;
    return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
  }
}
// @lc code=end
