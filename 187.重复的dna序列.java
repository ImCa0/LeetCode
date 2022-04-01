import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class FindRepeatedDnaSequences {
  public List<String> findRepeatedDnaSequences(String s) {
    int n = s.length();
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    for (int i = 10; i <= n; i++) {
      String subString = s.substring(i - 10, i);
      if (map.getOrDefault(subString, 0) == 1) {
        res.add(subString);
      }
      map.put(subString, map.getOrDefault(subString, 0) + 1);
    }
    return res;
  }
}
// @lc code=end
