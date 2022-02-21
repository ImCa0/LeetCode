/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

/*
 * 动态规划
 * f(i) 为以 nums[i] 结尾的 “最大子序和”
 * f(i) 只能是 f(i + 1) + nums[i] 或 nums[i] 本身，我们希望获得一个较大的
 * 动态转移方程为 f(i) = max{f(i - 1) + nums[i], nums[i]}
 */
// @lc code=start
class MaxSubArray {
    public int maxSubArray(int[] nums) {
      int pre = 0;
      int max = nums[0];
      for (int i : nums) {
        pre = Math.max(pre + i, i);
        max = Math.max(max, pre);
      }
      return max;
    }
}
// @lc code=end

