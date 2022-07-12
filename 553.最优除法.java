/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class OptimalDivision {
  public String optimalDivision(int[] nums) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      sb.append(nums[i]);
      sb.append('/');
    }
    sb.deleteCharAt(sb.length() - 1);
    if (nums.length > 2) {
      sb.insert(sb.indexOf("/") + 1, '(');
      sb.append(')');
    }
    return sb.toString();
  }
}
// @lc code=end
