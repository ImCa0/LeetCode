import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
class LargestDivisibleSubset {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    // 记录长度
    int[] dp = new int[n];
    // 记录来源
    int[] record = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      record[i] = i;
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            record[i] = j;
          }
        }
      }
    }
    int max = -1;
    int index = -1;
    for (int i = 0; i < n; i++) {
      if (dp[i] > max) {
        max = dp[i];
        index = i;
      }
    }
    List<Integer> res = new ArrayList<>();
    while (record[index] != index) {
      res.add(nums[index]);
      index = record[index];
    }
    res.add(nums[index]);
    return res;
  }
}
// @lc code=end
