/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class ClimbStairs {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int pre_1 = 1;
    int pre_2 = 2;
    int temp;
    for (int i = 3; i <= n; i++) {
      temp = pre_1 + pre_2;
      pre_1 = pre_2;
      pre_2 = temp;
    }
    return pre_2;
  }
}
// @lc code=end
