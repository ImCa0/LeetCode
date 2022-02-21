import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    int left = 0;
    int right = 0;
    Set<Character> set = new HashSet<>();
    while (right < s.length()) {
      while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      }
      set.add(s.charAt(right));
      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;
  }
}
// @lc code=end
