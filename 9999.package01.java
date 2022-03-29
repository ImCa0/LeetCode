/*
0-1 背包问题
有 N 件物品和一个容量是 C 的背包。每件物品有且只有一件。
第 i 件物品的体积是 v[i]，价值是 w[i]。
求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。

输入: N = 3, V = 4, v = [4,2,3], w = [4,2,3]
输出: 4
解释: 只选第一件物品，可使价值最大。

输入: N = 3, V = 5, v = [4,2,3], w = [4,2,3]
输出: 5
解释: 不选第一件物品，选择第二件和第三件物品，可使价值最大。
*/
class Package01 {
  int package01_1(int N, int C, int[] v, int[] w) {
    int[][] dp = new int[N][C + 1];
    for (int c = 0; c <= C; c++) {
      dp[0][c] = c >= v[0] ? w[0] : 0;
    }
    for (int i = 1; i < N; i++) {
      for (int c = 0; c <= C; c++) {
        if (c >= v[i]) {
          dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - v[i]] + w[i]);
        } else {
          dp[i][c] = dp[i - 1][c];
        }
      }
    }
    return dp[N - 1][C];
  }

  // 利用上一轮结果降维
  int package01_2(int N, int C, int[] v, int[] w) {
    int[] dp = new int[C + 1];
    for (int i = 0; i < N; i++) {
      for (int c = C; c >= v[i]; c--) {
        // 等号右边 dp[c] 表示不选当前物品，价值为上一轮的dp[c]
        // dp[c - v[i]] 表示选择当前物品，价值为上一轮的 dp[c - v[i]] 加当前物品价值
        dp[c] = Math.max(dp[c], dp[c - v[i]] + w[i]);
      }
    }
    return dp[C];
  }

  int package01_3(int N, int C, int[] v, int[] w) {
    return dfs(v, w, N - 1, C);
  }

  int dfs(int[] v, int[] w, int i, int c) {
    if (i == 0) {
      return c >= v[0] ? w[0] : 0;
    } else if (c >= v[i]) {
      return Math.max(dfs(v, w, i - 1, c), dfs(v, w, i - 1, c - v[i]) + w[i]);
    } else {
      return dfs(v, w, i - 1, c);
    }
  }
}
