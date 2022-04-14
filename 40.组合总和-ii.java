import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class CombinationSum2 {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> list = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    dfs(candidates, target, 0);
    return res;
  }

  void dfs(int[] candidates, int target, int index) {
    if (target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    if (index >= candidates.length || target < candidates[index]) {
      return;
    }
    list.add(candidates[index]);
    dfs(candidates, target - candidates[index], index + 1);
    list.remove(list.size() - 1);
    int next = index + 1;
    while (index < candidates.length - 1 && candidates[index] == candidates[next]) {
        index++;
        next++;
    }
    //选择一个本层中不重复的数
    dfs(candidates, target, next);
  }
}
// @lc code=end
