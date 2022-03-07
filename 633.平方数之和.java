/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class JudgeSquareSum {
  public boolean judgeSquareSum(int c) {
    int max = (int) Math.sqrt(c);
    for (int i = 0; i <= max; i++) {
      int j = (int) Math.sqrt(c - i * i);
      if (i * i + j * j == c) {
        return true;
      }
    }
    return false;
  }
}
// @lc code=end
