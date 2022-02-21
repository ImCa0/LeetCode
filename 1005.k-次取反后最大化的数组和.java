import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class LargestSumAfterKNegations {
  public int largestSumAfterKNegations(int[] nums, int k) {
    Arrays.sort(nums);
    int i = 0;
    while (nums[i] < 0 && k > 0 && i < nums.length - 1) {
      nums[i++] *= -1;
      k--;
    }
    Arrays.sort(nums);
    if (k % 2 != 0) {
      nums[0] *= -1;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }
}
// @lc code=end
