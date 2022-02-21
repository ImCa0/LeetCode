import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class HasCycle {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCycle2(ListNode head) {
    Set<ListNode> nodes = new HashSet<>();
    ListNode temp = head;
    while (temp != null) {
      if (nodes.contains(temp)) {
        return true;
      } else {
        nodes.add(temp);
        temp = temp.next;
      }
    }
    return false;
  }
}
// @lc code=end
