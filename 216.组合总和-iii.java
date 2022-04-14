import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class CombinationSum3 {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> list = new ArrayList<>();
  int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  int k;

  public List<List<Integer>> combinationSum3(int k, int n) {
    this.k = k;
    dfs(n, 0, 0);
    return res;
  }

  void dfs(int target, int index, int length) {
    if (length == k && target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    if (index >= 9 || length > k) {
      return;
    }
    list.add(nums[index]);
    dfs(target - nums[index], index + 1, list.size());
    list.remove(list.size() - 1);
    dfs(target, index + 1, list.size());
  }
}
// @lc code=end
