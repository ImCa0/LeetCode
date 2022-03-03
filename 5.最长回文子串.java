/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class LongestPalindrome {
  public String longestPalindrome(String s) {
    int n = s.length();
    if (n < 2) {
      return s;
    }
    char[] cs = s.toCharArray();
    boolean[][] dp = new boolean[n][n];
    int maxLength = 1;
    int index = 0;
    for (int length = 1; length <= n; length++) {
      for (int i = 0; i <= n - length; i++) {
        int j = i + length - 1;
        if (length == 1) {
          dp[i][j] = true;
        } else if (length == 2) {
          dp[i][j] = cs[i] == cs[j];
        } else {
          dp[i][j] = dp[i + 1][j - 1] && cs[i] == cs[j];
        }
        if (dp[i][j] == true) {
          if (j - i + 1 > maxLength) {
            maxLength = j - i + 1;
            index = i;
          }
        }
      }
    }
    return s.substring(index, index + maxLength);
  }
}
// @lc code=end
