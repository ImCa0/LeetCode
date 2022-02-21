import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边框着色
 */

// @lc code=start
class ColorBorder {
  public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    int target = grid[row][col];
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    List<int[]> borders = new ArrayList<>();
    dfs(grid, row, col, borders, target, visited);
    for (int[] border : borders) {
      grid[border[0]][border[1]] = color;
    }
    return grid;
  }

  void dfs(int[][] grid, int r, int c, List<int[]> borders, int target, boolean[][] visited) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
      return;
    }
    if (visited[r][c] || grid[r][c] != target) {
      return;
    }
    visited[r][c] = true;
    if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1) {
      borders.add(new int[] { r, c });
    } else if (grid[r - 1][c] != target || grid[r + 1][c] != target || grid[r][c - 1] != target
        || grid[r][c + 1] != target) {
      borders.add(new int[] { r, c });
    }
    dfs(grid, r - 1, c, borders, target, visited);
    dfs(grid, r + 1, c, borders, target, visited);
    dfs(grid, r, c - 1, borders, target, visited);
    dfs(grid, r, c + 1, borders, target, visited);
  }
}
// @lc code=end
