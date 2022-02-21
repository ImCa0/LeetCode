/*
 * @lc app=leetcode.cn id=689 lang=java
 *
 * [689] 三个无重叠子数组的最大和
 */

// @lc code=start
class MaxSumOfThreeSubarrays {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int[] res = new int[] { 0, k, 2 * k };
    int sum1 = 0, sum2 = 0, sum3 = 0;
    for (int i = 0; i < k; i++) {
      sum1 += nums[i];
      sum2 += nums[k + i];
      sum3 += nums[2 * k + i];
    }
    int max1 = sum1, max2 = max1 + sum2, max3 = max2 + sum3;
    int index11 = 0, index21 = 0, index22 = k;
    for (int i = 3 * k; i < nums.length; i++) {
      sum1 -= nums[i - 3 * k];
      sum2 -= nums[i - 2 * k];
      sum3 -= nums[i - k];
      sum1 += nums[i - 2 * k];
      sum2 += nums[i - k];
      sum3 += nums[i];
      if (sum1 > max1) {
        max1 = sum1;
        index11 = i - 3 * k + 1;
      }
      if (sum2 + max1 > max2) {
        max2 = sum2 + max1;
        index21 = index11;
        index22 = i - 2 * k + 1;
      }
      if (sum3 + max2 > max3) {
        max3 = sum3 + max2;
        res[0] = index21;
        res[1] = index22;
        res[2] = i - k + 1;
      }
    }
    return res;
  }
}
// @lc code=end
