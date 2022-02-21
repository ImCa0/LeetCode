/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class StrStr {
  public int strStr(String haystack, String needle) {
    if ("".equals(needle)) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
        if (j == needle.length() - 1) {
          return i;
        }
      }
    }
    return -1;
  }
}
// @lc code=end
