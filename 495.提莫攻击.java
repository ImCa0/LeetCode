/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class FindPoisonedDuration {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int res = 0;
    int n = timeSeries.length;
    for (int i = 1; i < n; i++) {
      int gap = timeSeries[i] - timeSeries[i - 1];
      res += gap >= duration ? duration : gap;
    }
    return res + duration;
  }
}
// @lc code=end
