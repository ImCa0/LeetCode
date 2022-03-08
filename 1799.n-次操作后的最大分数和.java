/*
 * @lc app=leetcode.cn id=1799 lang=java
 *
 * [1799] N 次操作后的最大分数和
 */

// @lc code=start
class MaxScore2 {
  public int maxScore(int[] nums) {
    int n = nums.length, m = 1 << n;
    int[] dp = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int k = (1 << i) | (1 << j);
        // 计算所有选两个数的状态 GCD
        dp[k] = gcd(nums[i], nums[j]);
      }
    }
    // 递推，从前往后
    for (int i = 1; i < m; i++) {
      int cnt_i = Integer.bitCount(i);
      // 偶数个数字
      if ((cnt_i & 1) == 1) {
        continue;
      }
      // 枚举 i 的子集
      for (int j = i; j > 0; j = (j - 1) & i) {
        int cnt_j = Integer.bitCount(j);
        // 子集的数字个数与 i 的数字个数差 2
        if (cnt_i - cnt_j == 2) {
          // dp[i ^ j] 为 j 的补集，cnt_i >> 1 当作是第 k 次操作
          // 由于 dp[j] 与 dp[i ^ j] 互补（即后续的 dp[j] 可能是之前的 dp[i ^ j])
          // (cnt_i >> 1) 会随着 i 一点点的把 (dp[j] or dp[i ^ j]) * (1 ~ k) 的所有
          // 情况全部枚举一次（甚至会重复枚举？？
          dp[i] = Math.max(dp[i], dp[j] + (cnt_i >> 1) * dp[i ^ j]);
        }
      }
    }
    return dp[m - 1];
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
// @lc code=end
