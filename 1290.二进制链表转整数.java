import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class GetDecimalValue {
  public int getDecimalValue1(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    int size = list.size();
    int res = 0;
    for (int i = 0; i < size; i++) {
      res += list.get(i) * Math.pow(2, size - i - 1);
    }
    return res;
  }

  // 遍历同时计算
  public int getDecimalValue2(ListNode head) {
    int res = 0;
    while (head != null) {
      res = res * 2 + head.val;
      head = head.next;
    }
    return res;
  }
}
// @lc code=end
