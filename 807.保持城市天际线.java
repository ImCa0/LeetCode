/*
 * @lc app=leetcode.cn id=807 lang=java
 *
 * [807] 保持城市天际线
 */

// @lc code=start
class MaxIncreaseKeepingSkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] r = new int[grid.length];
    int[] c = new int[grid[0].length];
    int before = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        r[i] = Math.max(r[i], grid[i][j]);
        c[j] = Math.max(c[j], grid[i][j]);
        before += grid[i][j];
      }
    }
    int after = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        grid[i][j] = Math.min(r[i], c[j]);
        after += grid[i][j];
      }
    }
    return after - before;
  }
}
// @lc code=end
