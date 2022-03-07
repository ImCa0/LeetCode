/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class LongestOnes {
  public int longestOnes(int[] nums, int k) {
    int n = nums.length;
    int left = 0, right = 0;
    int count = 0;
    int max = 0;
    while (right < n) {
      if (nums[right] == 0) {
        count++;
      }
      while (count > k) {
        if (nums[left] == 0) {
          count--;
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
      right++;
    }
    return max;
  }
}
// @lc code=end
