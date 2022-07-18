/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class FindTargetSumWays {
  public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += Math.abs(nums[i]);
    }
    if (Math.abs(target) > sum) {
      return 0;
    }
    int[][] dp = new int[n][2 * sum + 1];
    dp[0][nums[0] + sum] += 1;
    dp[0][-nums[0] + sum] += 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= 2 * sum; j++) {
        if (j - nums[i] >= 0) {
          dp[i][j] += dp[i - 1][j - nums[i]];
        }
        if (j + nums[i] <= 2 * sum) {
          dp[i][j] += dp[i - 1][j + nums[i]];
        }
      }
    }
    return dp[n - 1][target + sum];
  }
}
// @lc code=end
