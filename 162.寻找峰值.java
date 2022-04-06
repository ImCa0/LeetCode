/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class FindPeakElement {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    if (nums.length == 2) {
      return nums[0] > nums[1] ? 0 : 1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (isPeak(nums, mid)) {
        return mid;
      }
      if (goRight(nums, mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  boolean isPeak(int[] nums, int i) {
    if (i == 0 && nums[i] > nums[i + 1]) {
      return true;
    }
    if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
      return true;
    }
    if (i != 0 && i != nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
      return true;
    }
    return false;
  }

  boolean goRight(int[] nums, int i) {
    // 分类讨论
    // 1. nums[i - 1] < nums[i] < nums[i + 1] 向右走
    // 2. nums[i - 1] > nums[i] > nums[i + 1] 向左走
    // 3. nums[i - 1] > nums[i] < nums[i + 1] 向任意方向走
    // ↓ 综上 ↓
    if (nums[i] < nums[i + 1]) {
      return true;
    } else {
      return false;
    }
  }
}
// @lc code=end
