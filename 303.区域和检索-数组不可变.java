/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

  int[] dp;

  public NumArray(int[] nums) {
    int n = nums.length;
    dp = new int[n];
    dp[0] = nums[0];
    for (int i = 1; i < n; i++) {
      dp[i] = dp[i - 1] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    if (left == 0) {
      return dp[right];
    } else {
      return dp[right] - dp[left - 1];
    }
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end
