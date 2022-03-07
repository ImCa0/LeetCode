/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class CombinationSum4 {
  public int dp_optimized(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (num <= i) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }

  public int dp(int[] nums, int target) {
    // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
    int n = target;
    // dp[i][j] 表示长度为 i 的序列总和为 j 的方案数
    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;
    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= target; j++) {
        for (int num : nums) {
          if (num <= j) {
            dp[i][j] += dp[i - 1][j - num];
          }
        }
      }
      res += dp[i][target];
    }
    return res;
  }
}
// @lc code=end
