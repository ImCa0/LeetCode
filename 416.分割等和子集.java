/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class CanPartition {
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
    }
    if (sum % 2 == 1) {
      return false;
    }
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int i = 0; i < n; i++) {
      for (int j = target; j >= 0; j--) {
        boolean no = dp[j];
        boolean yes = j >= nums[i] ? dp[j - nums[i]] : false;
        dp[j] = no || yes;
      }
    }
    return dp[target];
  }
  public boolean canPartition2(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
    }
    // 奇数和不可能拆分
    if (sum % 2 == 1) {
      return false;
    }
    // 背包空间
    int target = sum / 2;
    boolean[][] dp = new boolean[n][target + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    for (int i = 0; i <= target; i++) {
      dp[0][i] = i == nums[0];
    }
    for (int i = 1; i < n; i++) {
      for (int t = 1; t <= target; t++) {
        // 不选当前数
        boolean no = dp[i - 1][t];
        // 选择当前数
        boolean yes = t >= nums[i] ? dp[i - 1][t - nums[i]] : false;
        dp[i][t] = no || yes;
      }
    }
    return dp[n - 1][target];
  }
}
// @lc code=end
