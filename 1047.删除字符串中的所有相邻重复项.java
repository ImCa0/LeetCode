/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class RemoveDuplicates2 {
  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();
    int top = -1;
    for (int i = 0; i < s.length(); i++) {
      if (top >= 0 && sb.charAt(top) == s.charAt(i)) {
        sb.deleteCharAt(top);
        top--;
      } else {
        sb.append(s.charAt(i));
        top++;
      }
    }
    return sb.toString();
  }
}
// @lc code=end
