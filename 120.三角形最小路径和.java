import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class MinimumTotal {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    for (int i = 1; i < n; i++) {
      triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
      triangle.get(i).set(i, triangle.get(i - 1).get(i - 1) + triangle.get(i).get(i));
    }
    for (int i = 2; i < n; i++) {
      for (int j = 1; j < i; j++) {
        triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
      }
    }
    triangle.get(n - 1).sort(Comparator.naturalOrder());
    return triangle.get(n - 1).get(0);
  }
}
// @lc code=end
