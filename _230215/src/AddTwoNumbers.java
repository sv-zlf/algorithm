/**
 * @author zlf
 * @data 2023/2/15
 * @apiNote LeetCode 2.两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){

//        ListNode node13=new ListNode(1,null);
//        ListNode node12= new ListNode(3,node13);
//        ListNode node11= new ListNode(4,node12);
//        ListNode node1 = new ListNode(2,node11);
//
//        ListNode node22=new ListNode(4,null);
//        ListNode node21 = new ListNode(6,node22);
//        ListNode node2 = new ListNode(5,node21);

//        ListNode node1=new ListNode(0);
//        ListNode node2=new ListNode(0);

        ListNode node16=new ListNode(9,null);
        ListNode node15=new ListNode(9,node16);
        ListNode node14=new ListNode(9,node15);
        ListNode node13=new ListNode(9,node14);
        ListNode node12= new ListNode(9,node13);
        ListNode node11= new ListNode(9,node12);
        ListNode node1 = new ListNode(9,node11);

        ListNode node23=new ListNode(9,null);
        ListNode node22=new ListNode(9,node23);
        ListNode node21 = new ListNode(9,node22);
        ListNode node2 = new ListNode(9,node21);

        ListNode node= addTwoNumbers(node2,node1);

        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        if (l1==null&&l2==null){
            return l1;
        }

        if (l1.val+l2.val>=10){
            if (l1.next==null){
                l1.next=new ListNode(0);
            }
            l1.val+=l2.val-10;
            l1.next.val+=1;
        }
        else {
            l1.val+=l2.val;
        }

        if (l2.next==null&&l1.next!=null){
            l2.next=new ListNode(0);
        }
        if (l1.next==null&&l2.next!=null){
            l1.next=new ListNode(0);
        }
        l1.next=addTwoNumbers(l1.next,l2.next);

        return l1;
    }
}
