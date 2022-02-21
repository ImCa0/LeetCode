/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
class MiddleNode {
  public ListNode middleNode(ListNode head) {
    ListNode mid = head, temp = head;
    while (temp != null && temp.next != null) {
      mid = mid.next;
      temp = temp.next.next;
    }
    return mid;
  }
}
// @lc code=end
