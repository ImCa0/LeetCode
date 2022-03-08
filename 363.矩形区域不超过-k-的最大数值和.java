/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */

// @lc code=start
class MaxSumSubmatrix {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int[][] sum = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        for (int p = i; p <= m; p++) {
          for (int q = j; q <= n; q++) {
            int cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];
            if (cur <= k) {
              ans = Math.max(ans, cur);
            }
          }
        }
      }
    }
    return ans;
  }
}
// @lc code=end
