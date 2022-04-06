/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class SearchRange {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] { -1, -1 };
    }
    int left = 0;
    int right = nums.length - 1;
    // 查找左边界
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    int leftIdx = right;
    if (nums[leftIdx] != target) {
      return new int[] { -1, -1 };
    }
    left = 0;
    right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    int rightIdx = right;
    return new int[] { leftIdx, rightIdx };
  }
}
// @lc code=end
