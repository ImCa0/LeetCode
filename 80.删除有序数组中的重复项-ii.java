/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class RemoveDuplicates3 {
  public int removeDuplicates(int[] nums) {
    int left = 1, right = 1, flag = 1;
    while (right < nums.length) {
      if (nums[right] != nums[right - 1]) {
        nums[left] = nums[right];
        left++;
        flag = 1;
      } else if (flag == 1) {
        nums[left] = nums[right];
        left++;
        flag++;
      }
      right++;
    }
    return left;
  }
}
// @lc code=end
