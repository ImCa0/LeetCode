/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class IsPerfectSquare {
  public boolean isPerfectSquare(int num) {
    long left = 0;
    long right = num;
    while (left < right) {
      long mid = left + (right - left) / 2;
      if (mid * mid < num) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right * right == num;
  }
}
// @lc code=end
