/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class MaxArea {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return max;
  }
}
// @lc code=end
