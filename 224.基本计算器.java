import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Calculate {
  public int calculate(String s) {
    ArrayDeque<Integer> nums = new ArrayDeque<>();
    ArrayDeque<Character> ops = new ArrayDeque<>();
    nums.addLast(0);
    s = s.replace(" ", "");
    char[] cs = s.toCharArray();
    for (int i = 0; i < cs.length; i++) {
      char c = cs[i];
      if (c == '(') {
        ops.addLast(c);
      } else if (c == ')') {
        while (ops.peekLast() != '(') {
          calc(nums, ops);
        }
        ops.pollLast();
      } else if (isNum(c)) {
        int sum = 0;
        int j = i;
        while (j < cs.length && isNum(cs[j])) {
          sum = sum * 10 + (cs[j] - '0');
          j++;
        }
        nums.addLast(sum);
        i = j - 1;
      } else {
        if (i > 0 && cs[i - 1] == '(') {
          nums.addLast(0);
        }
        while (!ops.isEmpty() && ops.peekLast() != '(') {
          calc(nums, ops);
        }
        ops.addLast(c);
      }
    }
    while (!ops.isEmpty()) {
      calc(nums, ops);
    }
    return nums.peekLast();
  }

  void calc(ArrayDeque<Integer> nums, ArrayDeque<Character> ops) {
    if (nums.size() < 2) return;
    if (ops.isEmpty()) return;
    int b = nums.pollLast();
    int a = nums.pollLast();
    char o = ops.pollLast();
    int c = o == '+' ? a + b : a - b;
    nums.addLast(c);
  }

  boolean isNum(char c) {
    return Character.isDigit(c);
  }
}
// @lc code=end
