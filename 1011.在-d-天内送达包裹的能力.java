/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class ShipWithinDays {
  public int shipWithinDays(int[] weights, int days) {
    // 最小边界为 weights 中的最大值
    int left = 0;
    // 最大边界为 weights 的总和
    int right = 0;
    for (int weight : weights) {
      left = Math.max(left, weight);
      right += weight;
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (canShip(weights, days, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }

  boolean canShip(int[] weights, int days, int cap) {
    int count = 0;
    int curr = 0;
    for (int weight : weights) {
      if (curr + weight <= cap) {
        curr += weight;
        continue;
      } else {
        count++;
        curr = weight;
      }
    }
    // 加上最后一天
    count++;
    return count <= days;
  }
}
// @lc code=end
