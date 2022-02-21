/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Search2 {
  public int search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    return bs(nums, 0, nums.length - 1, target);
  }

  int bs(int[] nums, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    int mid = (right - left) / 2 + left;
    if (target == nums[mid]) {
      return mid;
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
