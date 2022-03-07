import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1801 lang=java
 *
 * [1801] 积压订单中的订单总数
 */

// @lc code=start
class GetNumberOfBacklogOrders {
  public int getNumberOfBacklogOrders(int[][] orders) {
    // 购买订单队列
    PriorityQueue<int[]> buy = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
    // 出售订单队列
    PriorityQueue<int[]> sell = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
    for (int[] order : orders) {
      // 购买订单
      if (order[2] == 0) {
        // 订单量大于 0，出售订单队列不为空，出售订单最低价小于订单价格
        while (order[1] > 0 && !sell.isEmpty() && sell.peek()[0] <= order[0]) {
          if (order[1] > sell.peek()[1]) {
            order[1] -= sell.poll()[1];
          } else if (order[1] == sell.peek()[1]) {
            order[1] = 0;
            sell.poll();
          } else {
            int[] minSell = sell.poll();
            sell.add(new int[] { minSell[0], minSell[1] - order[1] });
            order[1] = 0;
          }
        }
        // 订单没有被完全消化
        if (order[1] > 0) {
          buy.add(new int[] { order[0], order[1] });
        }
      } else {
        while (order[1] > 0 && !buy.isEmpty() && buy.peek()[0] >= order[0]) {
          if (order[1] > buy.peek()[1]) {
            order[1] -= buy.poll()[1];
          } else if (order[1] == buy.peek()[1]) {
            order[1] = 0;
            buy.poll();
          } else {
            int[] maxBuy = buy.poll();
            buy.add(new int[] { maxBuy[0], maxBuy[1] - order[1] });
            order[1] = 0;
          }
        }
        if (order[1] > 0) {
          sell.add(new int[] { order[0], order[1] });
        }
      }
    }
    int res = 0;
    int mod = 1000000007;
    while (!buy.isEmpty()) {
      res += buy.poll()[1];
      res %= mod;
    }
    while (!sell.isEmpty()) {
      res += sell.poll()[1];
      res %= mod;
    }
    return res;
  }
}
// @lc code=end
