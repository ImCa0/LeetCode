/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class CharacterReplacement {
  public int characterReplacement(String s, int k) {
    int n = s.length();
    int left = 0, right = 0;
    int res = 0;
    int[] times = new int[26];
    int max = 0;
    while (right < n) {
      int index = s.charAt(right) - 'A';
      times[index]++;
      max = Math.max(max, times[index]);
      while (right - left + 1 > max + k) {
        int i = s.charAt(left) - 'A';
        times[i]--;
        left++;
      }
      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;
  }
}
// @lc code=end
