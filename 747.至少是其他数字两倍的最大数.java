/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class DominantIndex {
  public int dominantIndex(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int maxIdx = 0;
    int subMaxIdx = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[maxIdx]) {
        subMaxIdx = maxIdx;
        maxIdx = i;
      } else if (subMaxIdx == -1 || nums[i] > nums[subMaxIdx]) {
        subMaxIdx = i;
      }
    }
    return nums[maxIdx] >= 2 * nums[subMaxIdx] ? maxIdx : -1;
  }
}
// @lc code=end
