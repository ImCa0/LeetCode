/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode l1 = list1;
    ListNode l2 = list2;
    ListNode res = new ListNode();
    ListNode temp = res;
    while (l1 != null && l2 != null) {
      int next;
      if (l1.val < l2.val) {
        next = l1.val;
        l1 = l1.next;
      } else {
        next = l2.val;
        l2 = l2.next;
      }
      temp.next = new ListNode(next);
      temp = temp.next;
    }
    ListNode rest = l1 == null ? l2 : l1;
    temp.next = rest;
    return res.next;
  }
}
// @lc code=end
