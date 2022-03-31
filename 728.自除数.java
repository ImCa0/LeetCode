import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class SelfDividingNumbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> list = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (isTarget(i)) {
        list.add(i);
      }
    }
    return list;
  }

  boolean isTarget(int n) {
    int m = n;
    while (m != 0) {
      if (m % 10 == 0) {
        return false;
      } else if (n % (m % 10) != 0) {
        return false;
      }
      m /= 10;
    }
    return true;
  }
}
// @lc code=end
