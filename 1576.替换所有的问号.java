/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class ModifyString {
  public String modifyString(String s) {
    char[] cs = s.toCharArray();
    int n = cs.length;
    for (int i = 0; i < n; i++) {
      for (int c = 0; c < 3 && cs[i] == '?'; c++) {
        boolean ok = true;
        if (i - 1 >= 0 && cs[i - 1] == c + 'a')
          ok = false;
        if (i + 1 < n && cs[i + 1] == c + 'a')
          ok = false;
        if (ok)
          cs[i] = (char) (c + 'a');
      }
    }
    return String.valueOf(cs);
  }
}
// @lc code=end
