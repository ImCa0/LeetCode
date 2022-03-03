/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class MaxPower {
  public int maxPower(String s) {
    int left = 0, right = 0, power = 0;
    while (right < s.length()) {
      if (s.charAt(right) == s.charAt(left)) {
        power = Math.max(power, right - left + 1);
      } else {
        left = right;
      }
      right++;
    }
    return power;
  }
}
// @lc code=end
