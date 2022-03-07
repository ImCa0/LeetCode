/*
 * @lc app=leetcode.cn id=1423 lang=java
 *
 * [1423] 可获得的最大点数
 */

// @lc code=start
class MaxScore {
  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    int curr = 0;
    for (int i = 0; i < n; i++) {
      sum += cardPoints[i];
      if (i >= n - k) {
        min = Math.min(min, curr);
        curr -= cardPoints[i - n + k];
      }
      curr += cardPoints[i];
    }
    min = Math.min(min, curr);
    return sum - min;
  }
}
// @lc code=end
