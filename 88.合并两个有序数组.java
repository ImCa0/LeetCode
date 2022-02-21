/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Merge {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    while (m > 0 && n > 0) {
      if (nums1[m - 1] > nums2[n - 1]) {
        nums1[m + n - 1] = nums1[m - 1];
        m -= 1;
      } else {
        nums1[m + n - 1] = nums2[n - 1];
        n -= 1;
      }
    }
    if (m <= 0) {
      for (int i = n; i >= 1; i--) {
        nums1[i - 1] = nums2[i - 1];
      }
    }
  }
}
// @lc code=end
