/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class SetZeroes {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[] r = new boolean[m];
    boolean[] c = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          r[i] = true;
          c[j] = true;
        }
      }
    }
    for (int i = 0; i < r.length; i++) {
      if (r[i]) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int i = 0; i < c.length; i++) {
      if (c[i]) {
        for (int j = 0; j < m; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }
}
// @lc code=end
