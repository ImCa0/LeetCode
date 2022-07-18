/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class FindMaxForm {
  public int findMaxForm(String[] strs, int m, int n) {
    int length = strs.length;
    int[][][] dp = new int[length][m + 1][n + 1];
    int[] first = count(strs[0]);
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[0][i][j] = first[0] <= i && first[1] <= j ? 1 : 0;
      }
    }
    for (int i = 1; i < length; i++) {
      int[] count = count(strs[i]);
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= n; k++) {
          dp[i][j][k] = dp[i - 1][j][k];
          if (j - count[0] >= 0 && k - count[1] >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
          }
        }
      }
    }
    return dp[length - 1][m][n];
  }

  public int findMaxForm1(String[] strs, int m, int n) {
    int length = strs.length;
    int[][] dp = new int[m + 1][n + 1];
    int[] first = count(strs[0]);
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = first[0] <= i && first[1] <= j ? 1 : 0;
      }
    }
    for (int i = 1; i < length; i++) {
      int[] count = count(strs[i]);
      for (int j = m; j >= count[0]; j--) {
        for (int k = n; k >= count[1]; k--) {
          dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
        }
      }
    }
    return dp[m][n];
  }

  public int[] count(String s) {
    int zero = 0;
    int one = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        one++;
      } else {
        zero++;
      }
    }
    return new int[] { zero, one };
  }
}
// @lc code=end
