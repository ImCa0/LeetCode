import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class SingleNumber {
  public int singleNumber(int[] nums) {
    Set<Integer> appeared = new HashSet<>();
    Set<Integer> candidates = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!appeared.contains(nums[i])) {
        candidates.add(nums[i]);
        appeared.add(nums[i]);
      } else {
        candidates.remove(nums[i]);
      }
    }
    int res = -1;
    for (Integer candidate : candidates) {
      res = candidate;
    }
    return res;
  }
}
// @lc code=end
