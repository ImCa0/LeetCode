/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class MaxSatisfied {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int n = customers.length;
    int base = 0;
    for (int i = 0; i < n; i++) {
      if (grumpy[i] == 0) {
        base += customers[i];
      }
    }
    int max = 0;
    int curr = 0;
    for (int i = 0; i < n; i++) {
      if (grumpy[i] == 1) {
        curr += customers[i];
      }
      if (i >= minutes && grumpy[i - minutes] == 1) {
        curr -= customers[i - minutes];
      }
      max = Math.max(max, curr);
    }
    return base +max;
  }
}
// @lc code=end
