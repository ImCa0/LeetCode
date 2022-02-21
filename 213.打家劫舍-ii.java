import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Rob2 {
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(
        roooob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
        roooob(Arrays.copyOfRange(nums, 1, nums.length)));
  }

  int roooob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }
}
// @lc code=end
