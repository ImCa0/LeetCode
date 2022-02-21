/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class NumDecodings {
  public int numDecodings(String s) {
    // dp[i] 存储以第 i 位结尾的解码种数
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }

  public int numDecodings2(String s) {
    if (s.startsWith("0")) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    // dp[i][0] 存储第 i + 1 位以 1 位数结尾的解码种数
    // dp[i][1] 存储第 i + 1 位以 2 位数结尾的解码种数
    int[][] dp = new int[s.length()][2];
    dp[1][0] = s.charAt(1) == '0' ? 0 : 1;
    if ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26) {
      dp[1][1] = 1;
    } else {
      dp[1][1] = 0;
    }
    for (int i = 2; i < s.length(); i++) {
      dp[i][0] = s.charAt(i) == '0' ? 0 : dp[i - 1][0] + dp[i - 1][1];
      if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
        dp[i][1] = dp[i - 1][0];
      } else {
        dp[i][1] = 0;
      }
    }
    return dp[s.length() - 1][0] + dp[s.length() - 1][1];
  }
}
// @lc code=end
