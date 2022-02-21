/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class CountSegments {
  public int countSegments(String s) {
    String[] words = s.split(" +");
    int res = 0;
    for (String string : words) {
      if (!"".equals(string)) {
        res++;
      }
    }
    return res;
  }
}
// @lc code=end
