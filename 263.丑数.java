/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class IsUgly {
  public boolean isUgly(int n) {
    if (n <= 0) {
      return false;
    }
    for (int factor : new int[] { 2, 3, 5 }) {
      while (n % factor == 0) {
        n /= factor;
      }
    }
    return n == 1;
  }
}
// @lc code=end
