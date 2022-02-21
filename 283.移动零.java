/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int left = 0, right = 0;
    while (right < nums.length) {
      if (nums[right] != 0) {
        nums[left] = nums[right];
        left++;
      }
      right++;
    }
    while(left < nums.length) {
      nums[left] = 0;
      left++;
    }
  }
}
// @lc code=end
