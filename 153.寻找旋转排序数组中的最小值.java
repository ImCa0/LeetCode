/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class FindMin {
  public int findMin(int[] nums) {
    if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }
    return bs(nums, 0, nums.length - 1);
  }

  int bs(int[] nums, int left, int right) {
    int mid = (right - left) / 2 + left;
    if (nums[mid] > nums[mid + 1]) {
      return nums[mid + 1];
    }
    if (nums[mid] > nums[right]) {
      return bs(nums, mid, right);
    } else {
      return bs(nums, left, mid);
    }
  }
}
// @lc code=end
