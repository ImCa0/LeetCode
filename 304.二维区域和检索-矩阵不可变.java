/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {

  public int[][] preSum;

  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    preSum = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) {
          preSum[i][j] = matrix[i][j];
        } else {
          preSum[i][j] = preSum[i][j - 1] + matrix[i][j];
        }
      }
    }
    for (int j = 0; j < n; j++) {
      for (int i = 1; i < m; i++) {
        preSum[i][j] += preSum[i - 1][j];
      }
    }

  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row1 != 0 && col1 != 0) {
      return preSum[row2][col2] - preSum[row1 - 1][col2] - preSum[row2][col1 - 1]
          + preSum[row1 - 1][col1 - 1];
    } else if (row1 != 0) {
      return preSum[row2][col2] - preSum[row1 - 1][col2];
    } else if (col1 != 0) {
      return preSum[row2][col2] - preSum[row2][col1 - 1];
    } else {
      return preSum[row2][col2];
    }
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
