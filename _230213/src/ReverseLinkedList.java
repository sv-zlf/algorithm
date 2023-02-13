/**
 * @author zlf
 * @data 2023/2/13
 * @apiNote LeetCode 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node2=new ListNode(3,null);
        ListNode node1 = new ListNode(2,node2);
        ListNode node=new ListNode(1,node1);

        node=reverseList(node);
        while (node != null) {
            System.out.println(node.val);
            node=node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        else {
            head.next=reverseList(head.next);
            return head;
        }
    }
}
