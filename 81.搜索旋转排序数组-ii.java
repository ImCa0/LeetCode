/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Search3 {
  public boolean search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target;
    }
    return bs(nums, 0, nums.length - 1, target);
  }

  boolean bs(int[] nums, int left, int right, int target) {
    if (left > right) {
      return false;
    }
    int mid = (right - left) / 2 + left;
    if (target == nums[mid]) {
      return true;
    }
    if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
      return bs(nums, left + 1, right - 1, target);
    }
    if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && target < nums[mid]) {
        return bs(nums, left, mid - 1, target);
      } else {
        return bs(nums, mid + 1, right, target);
      }
    } else {
      if (nums[mid] < target && target <= nums[right]) {
        return bs(nums, mid + 1, right, target);
      } else {
        return bs(nums, left, mid - 1, target);
      }
    }
  }
}
// @lc code=end
