/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
  public int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;
    for (int i = 1; i < n; i++) {
      int res = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
      dp[i] = res;
      if (res == dp[p2] * 2) {
        p2++;
      }
      if (res == dp[p3] * 3) {
        p3++;
      }
      if (res == dp[p5] * 5) {
        p5++;
      }
    }
    return dp[n - 1];
  }
}
// @lc code=end
