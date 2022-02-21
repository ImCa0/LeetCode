/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class IsPalindrome2 {
  public boolean isPalindrome(String s) {
    char[] chars = new char[s.length()];
    int length = 0;
    s = s.toLowerCase();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetterOrDigit(s.charAt(i))) {
        chars[length] = s.charAt(i);
        length++;
      }
    }
    for (int left = 0, right = length - 1; left < right; left++, right--) {
      if (chars[left] != chars[right]) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome2(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }
}
// @lc code=end
