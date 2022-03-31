/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
class RemoveNthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode left = head;
    ListNode right = head;
    for (int i = 0; i < n + 1; i++) {
      if (right == null) {
        return head.next;
      }
      right = right.next;
    }
    while (right != null) {
      left = left.next;
      right = right.next;
    }
    left.next = left.next.next;
    return head;
  }
}
// @lc code=end
