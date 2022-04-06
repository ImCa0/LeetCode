package huawei;

import java.util.Scanner;

// 输出单向链表中倒数第k个结点
class HuaweiLinkedList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      ListNode head = new ListNode(-1);
      ListNode temp = head;
      for (int i = 0; i < n; i++) {
        int val = sc.nextInt();
        ListNode node = new ListNode(val);
        temp.next = node;
        temp = temp.next;
      }
      int target = sc.nextInt();
      if (target == 0) {
        System.out.println(0);
        continue;
      }
      ListNode left = head.next;
      ListNode right = head.next;
      for (int i = 0; i < target; i++) {
        right = right.next;
      }
      while (right != null) {
        right = right.next;
        left = left.next;
      }
      System.out.println(left.val);
    }
    sc.close();
  }
}

class ListNode {
  int val;
  ListNode next;
 
  ListNode(int val) {
    this.val = val;
  }
 
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
