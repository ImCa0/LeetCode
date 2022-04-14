import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class CombinationSum {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> list = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    dfs(candidates, target, 0);
    return res;
  }

  void dfs(int[] candidates, int target, int index) {
    if (target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    if (index >= candidates.length) {
      return;
    }
    for (int i = 0; target - candidates[index] * i >= 0; i++) {
      dfs(candidates, target - candidates[index] * i, index + 1);
      list.add(candidates[index]);
    }
    for (int i = 0; target - candidates[index] * i >= 0; i++) {
      list.remove(list.size() - 1);
    }
  }
}
// @lc code=end
