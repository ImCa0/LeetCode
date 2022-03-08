/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
  public boolean backspaceCompare(String s, String t) {
    return build(s).equals(build(t));
  }

  String build(String s) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '#') {
        sb.append(s.charAt(i));
      } else {
        if (sb.length() > 0) {
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }
    return sb.toString();
  }
}
// @lc code=end
