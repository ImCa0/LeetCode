/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class RemoveDuplicates {
  public int removeDuplicates(int[] nums) {
    int res = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[res - 1]) {
        continue;
      } else {
        nums[res] = nums[i];
        res++;
      }
    }
    return res;
  }
}
// @lc code=end
