/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
class DeleteDuplicates2 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode sentinel = new ListNode(-101, head);
    ListNode prev = sentinel;
    ListNode curr = sentinel.next;
    while (curr != null && curr.next != null) {
      if (curr.val == curr.next.val) {
        int delete = curr.val;
        while (curr != null && curr.val == delete) {
          curr = curr.next;
        }
        prev.next = curr;
      } else {
        curr = curr.next;
        prev = prev.next;
      }
    }
    return sentinel.next;
  }
}
// @lc code=end
