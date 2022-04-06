/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class PeakIndexInMountainArray {
  public int peakIndexInMountainArray(int[] arr) {
    int left = 1;
    int right = arr.length - 2;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < arr[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }
}
// @lc code=end
