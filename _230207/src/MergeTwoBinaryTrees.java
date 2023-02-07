import java.util.Stack;

/**
 * @author zlf
 * @data 2023/2/7
 * @apiNote 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class MergeTwoBinaryTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }

        Stack<TreeNode> node1 = new Stack<>();
        Stack<TreeNode> node2 = new Stack<>();
        node1.push(root1);
        node2.push(root2);
        root1.val=root1.val+root2.val;
        while (!node1.isEmpty()&&!node2.isEmpty()) {
            TreeNode r1=node1.pop();
            TreeNode r2=node2.pop();

            TreeNode zero =new TreeNode();
            zero.val=0;

            if (r1.left!=null)

        }
        return root1;
    }

}
