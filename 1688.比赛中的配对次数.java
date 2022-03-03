/*
 * @lc app=leetcode.cn id=1688 lang=java
 *
 * [1688] 比赛中的配对次数
 */

// @lc code=start
class NumberOfMatches {
  int sum = 0;

  public int numberOfMatches(int n) {
    if (n == 1) {
      return sum;
    }
    if (n % 2 == 0) {
      sum += n / 2;
      return numberOfMatches(n / 2);
    } else {
      sum += (n - 1) / 2;
      return numberOfMatches((n - 1) / 2 + 1);
    }
  }
}
// @lc code=end
