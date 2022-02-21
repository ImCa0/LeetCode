/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class TwoSum2 {
  // 双指针
  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      if (numbers[left] + numbers[right] == target) {
        return new int[] { left + 1, right + 1 };
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[] { 0, 0 };
  }

  // 双指针 + 二分查找
  public int[] twoSum2(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      int mid = (left + right) >>> 1;
      if (numbers[left] + numbers[mid] > target) {
        right = mid - 1;
      } else if (numbers[mid] + numbers[right] < target) {
        left = mid + 1;
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        return new int[] { left + 1, right + 1 };
      }
    }
    return new int[] { 0, 0 };
  }
}
// @lc code=end
