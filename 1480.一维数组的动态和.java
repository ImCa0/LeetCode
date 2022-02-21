/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
class RunningSum {
  public int[] runningSum(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res[i] = res[i - 1] + nums[i];
    }
    return res;
  }
}
// @lc code=end
