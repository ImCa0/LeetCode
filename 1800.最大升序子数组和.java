/*
 * @lc app=leetcode.cn id=1800 lang=java
 *
 * [1800] 最大升序子数组和
 */

// @lc code=start
class MaxAscendingSum {
  public int maxAscendingSum(int[] nums) {
    int res = nums[0], sum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        sum += nums[i];
      } else {
        res = Math.max(res, sum);
        sum = nums[i];
      }
    }
    res = Math.max(res, sum);
    return res;
  }
}
// @lc code=end
