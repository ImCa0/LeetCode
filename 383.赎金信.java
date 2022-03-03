import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class CanConstruct {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (char c : ransomNote.toCharArray()) {
      if (map.getOrDefault(c, 0) <= 0) {
        return false;
      } else {
        map.put(c, map.get(c) - 1);
      }
    }
    return true;
  }
}
// @lc code=end
