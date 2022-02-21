/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[res] = nums[i];
        res++;
      }
    }
    return res;
  }
}
// @lc code=end
