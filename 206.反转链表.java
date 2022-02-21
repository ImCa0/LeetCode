/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
class ReverseList {
  // 简洁
  public ListNode reverseList(ListNode head) {
    ListNode ans = null;
    for (ListNode x = head; x != null; x = x.next) {
      ans = new ListNode(x.val, ans);
    }
    return ans;
  }

  // 我的解
  public ListNode reverseList2(ListNode head) {
    ListNode old = head;
    ListNode newPrev = null;
    ListNode newCurr = null;
    while (old != null) {
      newCurr = new ListNode(old.val, newPrev);
      newPrev = newCurr;
      old = old.next;
    }
    return newCurr;
  }

  // 原地反转
  public ListNode reverseList3(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next;
    while (curr != null) {
      // 保存下一个值
      next = curr.next;
      // 当前节点指向前序结点
      curr.next = prev;
      // 整体前移
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
// @lc code=end
