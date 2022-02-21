/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
class RotateRight {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int length = 0;
    ListNode curr = head;
    while (curr != null) {
      length++;
      curr = curr.next;
    }
    if (k % length == 0) {
      return head;
    }
    curr = head;
    for (int i = 0; i < length - k % length - 1; i++) {
      curr = curr.next;
    }
    ListNode newHead = curr.next;
    curr.next = null;
    curr = newHead;
    for (int i = 0; i < k % length - 1; i++) {
      curr = curr.next;
    }
    curr.next = head;
    return newHead;
  }
}
// @lc code=end
