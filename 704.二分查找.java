/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Search {
  public int search(int[] nums, int target) {
    return bs(nums, 0, nums.length - 1, target);
  }

  int bs(int[] nums, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    int mid = (right - left) / 2 + left;
    if (target == nums[mid]) {
      return mid;
    } else if (target > nums[mid]) {
      return bs(nums, mid + 1, right, target);
    } else {
      return bs(nums, left, mid - 1, target);
    }
  }
}
// @lc code=end
