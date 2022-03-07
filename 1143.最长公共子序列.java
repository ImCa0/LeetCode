/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    // 添加空格方便产生初始值
    text1 = ' ' + text1;
    text2 = ' ' + text2;
    char[] cs1 = text1.toCharArray();
    char[] cs2 = text2.toCharArray();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i <= m; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (cs1[i] == cs2[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m] - 1;
  }
}
// @lc code=end
