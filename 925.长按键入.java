/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class IsLongPressedName {
  public boolean isLongPressedName(String name, String typed) {
    int i = 0, j = 0;
    while (j < typed.length()) {
      if (i < name.length() && typed.charAt(j) == name.charAt(i)) {
        i++;
        j++;
      } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
        j++;
      } else {
        return false;
      }
    }
    return i == name.length();
  }
}
// @lc code=end
