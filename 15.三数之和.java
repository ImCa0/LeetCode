import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        if (left > i + 1 && nums[left] == nums[left - 1]) {
          left++;
          continue;
        }
        if (right < n - 1 && nums[right] == nums[right + 1]) {
          right--;
          continue;
        }
        if (nums[left] + nums[right] > target) {
          right--;
        } else if (nums[left] + nums[right] < target) {
          left++;
        } else {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[left]);
          list.add(nums[right]);
          res.add(list);
          left++;
          right--;
        }
      }
    }
    return res;
  }
}
// @lc code=end
