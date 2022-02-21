/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class SortedSquares {
  public int[] sortedSquares(int[] nums) {
    int i = 0, j = 0;
    for (int x = 0; x < nums.length - 1; x++) {
      if (nums[x] < 0) {
        i = x;
      } else {
        break;
      }
    }
    j = i + 1;
    int[] res = new int[nums.length];
    int index = 0;
    while (i >= 0 || j < nums.length) {
      if (i < 0) {
        res[index] = nums[j] * nums[j];
        j++;
      } else if (j >= nums.length) {
        res[index] = nums[i] * nums[i];
        i--;
      } else if (-nums[i] > nums[j]) {
        res[index] = nums[j] * nums[j];
        j++;
      } else {
        res[index] = nums[i] * nums[i];
        i--;
      }
      index++;
    }
    return res;
  }
}
// @lc code=end
