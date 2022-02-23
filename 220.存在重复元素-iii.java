import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class ContainsNearbyAlmostDuplicate {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> ts = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Long u = nums[i] * 1L;
      Long left = ts.floor(u);
      Long right = ts.ceiling(u);
      if (left != null && u - left <= t) {
        return true;
      }
      if (right != null && right - u <= t) {
        return true;
      }
      ts.add(u);
      if (i >= k) {
        ts.remove(nums[i - k] * 1L);
      }
    }
    return false;
  }
}
// @lc code=end
