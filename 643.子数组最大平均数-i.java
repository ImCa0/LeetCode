/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class FindMaxAverage {
  public double findMaxAverage(int[] nums, int k) {
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int max = sum;
    for (int i = 0; i < n - k; i++) {
      sum -= nums[i];
      sum += nums[i + k];
      max = Math.max(max, sum);
    }
    return max * 1.0 / k;
  }
}
// @lc code=end
