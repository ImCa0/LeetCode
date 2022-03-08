/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start

// public class Solution {
class HammingWeight {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) != 0) {
        res++;
      }
    }
    return res;
  }
}
// @lc code=end
