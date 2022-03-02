import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1575 lang=java
 *
 * [1575] 统计所有可行路径
 */

// @lc code=start
class DP {
  int mod = 1000000007;
  public int countRoutes(int[] locations, int start, int finish, int fuel) {
    int n = locations.length;
    // dp[i][fuel] 代表在 i 位置且油量为 fuel 时，到达终点的路径数
    // dp[i][fuel] += dp[j][fuel - need]
    int[][] dp = new int[n][fuel + 1];
    for (int i = 0; i <= fuel; i++) {
      dp[finish][i] = 1;
    }

    for (int f = 0; f <= fuel; f++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j) {
            int need = Math.abs(locations[i] - locations[j]);
            if (need <= f) {
              dp[i][f] += dp[j][f - need];
              dp[i][f] %= mod;
            }
          }
        }
      }
    }
    return dp[start][fuel];
  }
}

class DFS {
  int[][] cache;
  int mod = 1000000007;

  public int countRoutes(int[] locations, int start, int finish, int fuel) {
    int n = locations.length;
    cache = new int[n][fuel + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }
    return dfs(locations, start, finish, fuel);
  }

  public int dfs(int[] locations, int curr, int finish, int fuel) {
    int n = locations.length;
    if (cache[curr][fuel] != -1) {
      return cache[curr][fuel];
    }
    if (fuel == 0) {
      cache[curr][fuel] = curr == finish ? 1 : 0;
      return cache[curr][fuel];
    }
    boolean hasNext = false;
    for (int i = 0; i < n; i++) {
      if (i != curr) {
        if (Math.abs(locations[i] - locations[curr]) <= fuel) {
          hasNext = true;
          break;
        }
      }
    }
    if (fuel > 0 && !hasNext) {
      cache[curr][fuel] = curr == finish ? 1 : 0;
      return cache[curr][fuel];
    }
    int sum = curr == finish ? 1 : 0;
    for (int i = 0; i < n; i++) {
      if (i != curr) {
        int need = Math.abs(locations[i] - locations[curr]);
        if (need <= fuel) {
          sum += dfs(locations, i, finish, fuel - need);
          sum %= mod;
        }
      }
    }
    cache[curr][fuel] = sum;
    return cache[curr][fuel];
  }
}
// @lc code=end
