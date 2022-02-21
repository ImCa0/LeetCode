/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class ReverseVowels {
  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    int left = 0, right = n - 1;
    while (left < right) {
      while (left < n && !isVowel(chars[left])) {
        left++;
      }
      while (right > 0 && !isVowel(chars[right])) {
        right--;
      }
      if (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      }
    }
    return new String(chars);
  }

  public boolean isVowel(char ch) {
    return "aeiouAEIOU".indexOf(ch) >= 0;
  }
}
// @lc code=end
