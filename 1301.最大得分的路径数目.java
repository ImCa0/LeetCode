import java.util.List;

/*
 * @lc app=leetcode.cn id=1301 lang=java
 *
 * [1301] 最大得分的路径数目
 */

// @lc code=start
class PathsWithMaxScore {
  int n;
  int mod = 1000000007;

  public int[] pathsWithMaxScore(List<String> board) {
    n = board.size();

    char[][] gird = new char[n][n];
    for (int i = 0; i < n; i++) {
      gird[i] = board.get(i).toCharArray();
    }

    // dp[i] 表示从起点走到下标为 i 的格子最大得分
    int[] dp = new int[n * n];
    // sum[i] 表示最大得分的路径数
    int[] sum = new int[n * n];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int idx = getIdx(i, j);
        if (i == n - 1 && j == n - 1) {
          dp[idx] = 0;
          sum[idx] = 1;
          continue;
        }
        if (gird[i][j] == 'X') {
          dp[idx] = Integer.MIN_VALUE;
          sum[idx] = 0;
          continue;
        }
        // 当前格子分数
        int val = (i == 0 && j == 0) ? 0 : gird[i][j] - '0';
        int score = Integer.MIN_VALUE;
        int count = 0;
        if (i + 1 < n) {
          int newScore = dp[getIdx(i + 1, j)] + val;
          int newCount = sum[getIdx(i + 1, j)];
          int[] res = update(newScore, newCount, score, count);
          score = res[0];
          count = res[1];
        }
        if (j + 1 < n) {
          int newScore = dp[getIdx(i, j + 1)] + val;
          int newCount = sum[getIdx(i, j + 1)];
          int[] res = update(newScore, newCount, score, count);
          score = res[0];
          count = res[1];
        }
        if (i + 1 < n && j + 1 < n) {
          int newScore = dp[getIdx(i + 1, j + 1)] + val;
          int newCount = sum[getIdx(i + 1, j + 1)];
          int[] res = update(newScore, newCount, score, count);
          score = res[0];
          count = res[1];
        }
        dp[getIdx(i, j)] = score < 0 ? Integer.MIN_VALUE : score;
        sum[getIdx(i, j)] = count;
      }
    }
    int[] ans = new int[2];
    ans[0] = dp[0] == Integer.MIN_VALUE ? 0 : dp[0];
    ans[1] = sum[0] == Integer.MIN_VALUE ? 0 : sum[0];
    return ans;
  }

  int[] update(int newScore, int newCount, int score, int count) {
    if (newScore > score) {
      score = newScore;
      count = newCount;
    } else if (newScore == score && count != Integer.MIN_VALUE) {
      count += newCount;
    }
    count %= mod;
    return new int[] { score, count };
  }

  // 坐标、下标转换
  int getIdx(int x, int y) {
    return n * x + y;
  }

  int[] parseIdx(int idx) {
    return new int[] { idx / n, idx % n };
  }
}
// @lc code=end
