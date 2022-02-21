/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
class IsPalindrome3 {
  // 空间复杂度 O(1)
  public boolean isPalindrome(ListNode head) {
    ListNode temp = head, mid = head;
    while (temp != null && temp.next != null) {
      mid = mid.next;
      temp = temp.next.next;
    }
    // 反转后半部分链表 见206
    ListNode prev = null;
    ListNode curr = mid;
    ListNode next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    // prev 为尾节点 也是翻转后的头节点
    while (prev != null) {
      if (head.val != prev.val) {
        return false;
      }
      head = head.next;
      prev = prev.next;
    }
    return true;
  }
}
// @lc code=end
