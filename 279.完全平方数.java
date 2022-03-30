import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class NumSquares {
  public int numSquares(int n) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      list.add(i * i);
    }
    int[] dp = new int[n + 1];
    // list[0] = 1 一定可以凑出结果
    for (int i = 0; i <= n; i++) {
      dp[i] = i;
    }
    for (int i = 1; i < list.size(); i++) {
      for (int j = 0; j <= n; j++) {
        int no = dp[j];
        int yes = j >= list.get(i) ? dp[j - list.get(i)] + 1 : Integer.MAX_VALUE;
        dp[j] = Math.min(no, yes);
      }
    }
    return dp[n];
  }
}
// @lc code=end
