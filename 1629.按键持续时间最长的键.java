/*
 * @lc app=leetcode.cn id=1629 lang=java
 *
 * [1629] 按键持续时间最长的键
 */

// @lc code=start
class SlowestKey {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int n = releaseTimes.length;
    int maxTime = releaseTimes[0];
    char res = keysPressed.charAt(0);
    for (int i = 1; i < n; i++) {
      int time = releaseTimes[i] - releaseTimes[i - 1];
      char c = keysPressed.charAt(i);
      if (time > maxTime) {
        maxTime = time;
        res = c;
      } else if (time == maxTime && c > res) {
        res = c;
      }
    }
    return res;
  }
}
// @lc code=end
