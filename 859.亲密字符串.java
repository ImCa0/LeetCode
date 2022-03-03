/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class BuddyStrings {
  public boolean buddyStrings(String s, String goal) {
    char[] a = s.toCharArray();
    char[] b = goal.toCharArray();
    if (a.length != b.length) {
      return false;
    }
    int[] idxs = {-1, -1};
    int j = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        if (j >= 2) {
          return false;
        } else {
          idxs[j++] = i;
        }
      }
    }
    if (idxs[0] == -1 || idxs[1] == -1) {
      if (s.equals(goal)) {
        int[] cnt = new int[26];
        for (int i = 0; i < a.length; i++) {
          cnt[a[i] - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
          if (cnt[i] >= 2) {
            return true;
          }
        }
      }
      return false;
    }
    if (a[idxs[0]] == b[idxs[1]] && a[idxs[1]] == b[idxs[0]]) {
      return true;
    }
    return false;
  }
}
// @lc code=end
