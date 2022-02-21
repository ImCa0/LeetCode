/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class IsPalindrome {
    public boolean isPalindrome(int x) {
      String str = Integer.toString(x);
      int length = str.length();
      for (int i = 0; i < length / 2; i++) {
        if (str.charAt(i) != str.charAt(length - 1 - i)) {
          return false;
        }
      }
      return true;
    }
}
// @lc code=end

