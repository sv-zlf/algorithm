/**
 * @author zlf
 * @data 2023/2/2
 * @apiNote 删除链表的倒数第 N 个结点
 * 删除链表的倒数第 N 个结点
 */
public class RemoveListNode {

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
        //ListNode listNode5=new ListNode(5,listNode6);
        //ListNode listNode4=new ListNode(4,listNode5);
        //ListNode listNode3=new ListNode(3,null);
        //ListNode listNode2=new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,null);
        ListNode listNode=removeNthFromEnd(listNode1,1);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode low=dummy;
        ListNode fast=head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            low=low.next;
            fast=fast.next;
        }
        low.next=low.next.next;
        return dummy.next;
    }
}
