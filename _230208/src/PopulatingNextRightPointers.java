import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zlf
 * @data 2023/2/8
 * @apiNote LeetCode 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 */
public class PopulatingNextRightPointers {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node node7=new Node(7);
        Node node6=new Node(6);
        Node node5=new Node(5);
        Node node4=new Node(4);
        Node node3=new Node(3,node6,node7,null);
        Node node2=new Node(2,node4,node5,null);
        Node node1=new Node(1,node2,node3,null);

        connect(node1);
    }

    public static Node connect(Node root) {

        if (root==null) return null;

        Queue<Node> que = new LinkedList<>() ;
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                if (i < size - 1) {
                    node.next = que.peek();
                    System.out.println(que.peek().val);
                }
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
        }
        return root;
    }


}
