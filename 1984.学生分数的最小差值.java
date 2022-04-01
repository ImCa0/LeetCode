import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1984 lang=java
 *
 * [1984] 学生分数的最小差值
 */

// @lc code=start
class MinimumDifference {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0;
    int right = k - 1;
    int n = nums.length;
    int min = 0x3f3f3f3f;
    while (right < n) {
      min = Math.min(min, nums[right] - nums[left]);
      left++;
      right++;
    }
    return min;
  }
}
// @lc code=end
