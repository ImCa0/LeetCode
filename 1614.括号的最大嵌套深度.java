/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
class MaxDepth2 {
  public int maxDepth(String s) {
    int n = s.length();
    int deep = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        deep++;
        max = Math.max(max, deep);
      } else if (s.charAt(i) == ')') {
        deep--;
      }
    }
    return max;
  }
}
// @lc code=end
