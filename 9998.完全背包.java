class PackageComplete {
  int packageComplete(int N, int C, int[] v, int[] w) {
    int[][] dp = new int[N][C + 1];
    for (int i = 0; i <= C; i++) {
      dp[0][i] = i / v[0] * w[0];
    }
    for (int i = 1; i < N; i++) {
      for (int j = 0; j <= C; j++) {
        for (int k = 0; k * v[i] <= j; k++) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
        }
      }
    }
    return dp[N - 1][C];
  }

  // 推荐 降维
  int packageComplete2(int N, int C, int[] v, int[] w) {
    int[] dp = new int[C + 1];
    for (int i = 0; i < N; i++) {
      for (int j = v[i]; j <= C; j++) {
        dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
      }
    }
    return dp[C];
  }
}
