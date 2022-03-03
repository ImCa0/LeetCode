/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class ReverseStr {
  public String reverseStr(String s, int k) {
    char[] cs = s.toCharArray();
    int n = s.length();
    for (int i = 0; i < n; i += 2 * k) {
      if (i + k - 1 < n) {
        reverse(cs, i, i + k - 1);
      } else {
        reverse(cs, i, n - 1);
      }
    }
    return String.valueOf(cs);
  }

  void reverse(char[] cs, int i, int j) {
    while (i < j) {
      char temp = cs[i];
      cs[i] = cs[j];
      cs[j] = temp;
      i++;
      j--;
    }
  }
}
// @lc code=end
