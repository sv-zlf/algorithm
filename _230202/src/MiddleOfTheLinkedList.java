/**
 * @author zlf
 * @data 2023/2/2
 * @apiNote 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleOfTheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
        ListNode listNode6=new ListNode(6,null);
        //ListNode listNode5=new ListNode(5,null);
        ListNode listNode5=new ListNode(5,listNode6);
        ListNode listNode4=new ListNode(4,listNode5);
        ListNode listNode3=new ListNode(3,listNode4);
        ListNode listNode2=new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,listNode2);

        System.out.println(middleNode(listNode1).val);
  }

    public static ListNode middleNode(ListNode head) {
        ListNode mid=head;
        ListNode end=head;
        while (end != null) {
            end=end.next;
            if (end == null) {
                break;
            }
            mid=mid.next;
            end = end.next;
        }
        return mid;
    }
}
