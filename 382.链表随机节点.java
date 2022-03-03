import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
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
class GetRandom {

  List<Integer> ls = new ArrayList<>();

  public GetRandom(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      ls.add(temp.val);
      temp = temp.next;
    }
  }

  public int getRandom() {
    int n = ls.size();
    Random random = new Random();
    return ls.get(random.nextInt(n));
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end
