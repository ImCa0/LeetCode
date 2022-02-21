/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class MaxPower {
  public int maxPower(String s) {
    char curr = s.charAt(0);
    int left = 0, right = 1, max = 1;
    while (right < s.length()) {
      if (s.charAt(right) == curr) {
        max = Math.max(max, right - left + 1);
      } else {
        left = right;
        curr = s.charAt(right);
      }
      right++;
    }
    return max;
  }
}
// @lc code=end
