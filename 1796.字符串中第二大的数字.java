import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1796 lang=java
 *
 * [1796] 字符串中第二大的数字
 */

// @lc code=start
class SecondHighest {
  public int secondHighest(String s) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        set.add(Character.getNumericValue(ch));
      }
    }
    int max = -1, subMax = -1;
    for (Integer i : set) {
      if (i > max) {
        subMax = max;
        max = i;
      } else if (i > subMax) {
        subMax = i;
      }
    }
    return subMax;
  }
}
// @lc code=end
