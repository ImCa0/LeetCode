/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = new ListNode();
    ListNode temp = res;
    int forward = 0;
    while (l1 != null || l2 != null || forward != 0) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      sum += forward;
      forward = sum / 10;
      temp.next = new ListNode(sum % 10);
      temp = temp.next;
    }
    return res.next;
  }
}
// @lc code=end
