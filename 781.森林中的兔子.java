
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=781 lang=java
 *
 * [781] 森林中的兔子
 */

// @lc code=start
class NumRabbits {
  public int numRabbits(int[] answers) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int answer : answers) {
      map.put(answer, map.getOrDefault(answer, 0) + 1);
    }
    for (int key : map.keySet()) {
      int colors = map.get(key) / (key + 1);
      if (colors * (key + 1) < map.get(key)) {
        colors++;
      }
      res += colors * (key + 1);
    }
    return res;
  }
}
// @lc code=end
