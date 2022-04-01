/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class PivotIndex {
  public int pivotIndex(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
    }
    int pre = 0;
    for (int i = 0; i < n; i++) {
      if ((sum - nums[i]) % 2 == 0) {
        int target = (sum - nums[i]) / 2;
        if (pre == target) {
          return i;
        }
      }
      pre += nums[i];
    }
    return -1;
  }
}
// @lc code=end
