/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    int[] min = new int[cost.length + 1];
    min[0] = 0;
    min[1] = 0;
    for (int i = 2; i < min.length; i++) {
      min[i] = Math.min(min[i - 2] + cost[i - 2], min[i - 1] + cost[i - 1]);
    }
    return min[min.length - 1];
  }
}
// @lc code=end
