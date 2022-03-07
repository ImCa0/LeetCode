/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边框着色
 */

// @lc code=start
class ColorBorder {
  public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    // 0 未访问
    // 1 已访问 不是边界
    // 2 已访问 是边界
    int[][] status = new int[grid.length][grid[0].length];
    int origin = grid[row][col];
    dfs(grid, status, row, col, origin);
    for (int i = 0; i < status.length; i++) {
      for (int j = 0; j < status[0].length; j++) {
        if (status[i][j] == 2) {
          grid[i][j] = color;
        }
      }
    }
    return grid;
  }

  void dfs(int[][] grid, int[][] status, int r, int c, int origin) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
      return;
    }
    if (status[r][c] != 0) {
      return;
    }
    if (grid[r][c] != origin) {
      return;
    }
    if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1) {
      status[r][c] = 2;
    } else if (grid[r - 1][c] != origin || grid[r + 1][c] != origin || grid[r][c - 1] != origin
        || grid[r][c + 1] != origin) {
      status[r][c] = 2;
    } else {
      status[r][c] = 1;
    }
    dfs(grid, status, r - 1, c, origin);
    dfs(grid, status, r + 1, c, origin);
    dfs(grid, status, r, c - 1, origin);
    dfs(grid, status, r, c + 1, origin);
  }
}
// @lc code=end
