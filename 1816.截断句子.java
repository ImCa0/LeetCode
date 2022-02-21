/*
 * @lc app=leetcode.cn id=1816 lang=java
 *
 * [1816] 截断句子
 */

// @lc code=start
class TruncateSentence {
  public String truncateSentence(String s, int k) {
    String[] words = s.split(" ");
    StringBuilder sb = new StringBuilder(words[0]);
    for (int i = 1; i < k; i++) {
      sb.append(" ");
      sb.append(words[i]);
    }
    return sb.toString();
  }
}
// @lc code=end
