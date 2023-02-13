/**
 * @author zlf
 * @data 2023/2/13
 * @apiNote LeetCode 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node12=new ListNode(4,null);
        ListNode node11 = new ListNode(2,node12);
        ListNode node1=new ListNode(1,node11);

        ListNode node22 = new ListNode(4,null);
        ListNode node21=new ListNode(3,node22);
        ListNode node2=new ListNode(1,node21);

        ListNode node=mergeTwoLists(node1,node2);

        while (node != null) {
            System.out.println(node.val);
            node=node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2==null){
            return list1;
        }

        if (list1.val< list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
