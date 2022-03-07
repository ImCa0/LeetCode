import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1006 lang=java
 *
 * [1006] 笨阶乘
 */

// @lc code=start
class Clumsy {
  public int clumsy(int n) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('+', 1);
    map.put('-', 1);
    map.put('*', 2);
    map.put('/', 2);
    Deque<Integer> nums = new ArrayDeque<>();
    Deque<Character> ops = new ArrayDeque<>();
    char[] op = { '*', '/', '+', '-' };
    for (int i = n, j = 0; i > 0; i--, j++) {
      nums.add(i);
      char o = op[j % 4];
      while (!ops.isEmpty()) {
        char prev = ops.peekLast();
        if (map.get(prev) >= map.get(o)) {
          calc(nums, ops);
        } else {
          break;
        }
      }
      if (i != 1) {
        ops.add(o);
      }
    }
    while (!ops.isEmpty()) {
      calc(nums, ops);
    }
    return nums.peekLast();
  }

  void calc(Deque<Integer> nums, Deque<Character> ops) {
    int b = nums.pollLast();
    int a = nums.pollLast();
    char o = ops.pollLast();
    int c;
    if (o == '+') {
      c = a + b;
    } else if (o == '-') {
      c = a - b;
    } else if (o == '*') {
      c = a * b;
    } else {
      c = a / b;
    }
    nums.addLast(c);
  }
}
// @lc code=end
