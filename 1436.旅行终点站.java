import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start
class DestCity {
  public String destCity(List<List<String>> paths) {
    Map<String, String> map = new HashMap<>();
    for (List<String> path : paths) {
      map.put(path.get(0), path.get(1));
    }
    String from = paths.get(0).get(0);
    while (map.containsKey(from)) {
      from = map.get(from);
    }
    return from;
  }
}
// @lc code=end
