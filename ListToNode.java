/**
 * ListToNode
 */
public class ListToNode {

  public static ListNode toListNode(int[] list) {
    ListNode listNode = new ListNode();
    ListNode temp = listNode;
    for (int val : list) {
      temp.next = new ListNode(val);
      temp = temp.next;
    }
    return listNode.next;
  }
}