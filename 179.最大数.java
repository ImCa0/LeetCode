import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] ss = new String[nums.length];
    for (int i = 0; i < ss.length; i++) {
      ss[i] = "" + nums[i];
    }
    Arrays.sort(ss, (a, b) -> {
      String sa = a + b, sb = b + a;
      return sb.compareTo(sa);
    });
    StringBuilder sb = new StringBuilder();
    for (String s : ss) {
      sb.append(s);
    }
    int i = 0;
    while (i < sb.length() - 1 && sb.charAt(i) == '0') {
      i++;
    }
    return sb.substring(i);
  }
}
// @lc code=end
