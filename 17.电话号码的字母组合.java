import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
  Map<String, String[]> map = new HashMap<String, String[]>() {
    {
      put("2", new String[] { "a", "b", "c" });
      put("3", new String[] { "d", "e", "f" });
      put("4", new String[] { "g", "h", "i" });
      put("5", new String[] { "j", "k", "l" });
      put("6", new String[] { "m", "n", "o" });
      put("7", new String[] { "p", "q", "r", "s" });
      put("8", new String[] { "t", "u", "v" });
      put("9", new String[] { "w", "x", "y", "z" });
    }
  };
  List<String> res = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    int n = digits.length();
    if (n == 0) {
      return res;
    }
    StringBuilder sb = new StringBuilder();
    dfs(digits, 0, n, sb);
    return res;
  }

  void dfs(String digits, int i, int n, StringBuilder sb) {
    if (i == n) {
      res.add(sb.toString());
      return;
    }
    String key = digits.substring(i, i + 1);
    String[] value = map.get(key);
    for (String s : value) {
      sb.append(s);
      dfs(digits, i + 1, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
// @lc code=end
