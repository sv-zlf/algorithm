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

        TreeNode root1right=new TreeNode(2,null,null);
        TreeNode root1leftleft=new TreeNode(5,null,null);
        TreeNode root1left =new TreeNode(3,root1leftleft,null);
        TreeNode root1=new TreeNode(1,root1left,root1right);

        TreeNode root2rightright=new TreeNode(7,null,null);
        TreeNode root2right=new TreeNode(3,null,root2rightright);
        TreeNode root2leftright=new TreeNode(4,null,null);
        TreeNode root2left=new TreeNode(1,null,root2leftright);
        TreeNode root2=new TreeNode(2,root2left,root2right);

        TreeNode root=mergeTrees(root1,root2);
        System.out.println(root.left.val);

    }

    public static TreeNode mergeTreesWithoutDiGui(TreeNode root1, TreeNode root2) {

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
            
            if (r1.left!=null||r2.left!=null){
                if (r1.left!=null&&r2.left!=null){
                    r1.val+=r2.val;
                    r1=r1.left;
                    r2=r2.left;
                }
                else if(r1.left!=null){
                    r1=r1.left;
                }
                else {
                    r1.val=r2.val;
                    r2=r2.left;
                }
            }

            if (r1.right!=null||r2.right!=null){
                if (r1.right!=null&&r2.right!=null){
                    r1.val+=r2.val;
                    r1=r1.right;
                    r2=r2.right;
                }
                else if(r1.right!=null){
                    r1=r1.right;
                }
                else {
                    r1.val=r2.val;
                    r2=r2.right;
                }
            }

            node1.push(r1);
            node2.push(r2);

        }
        return root1;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1==null) {
            return root2;
        }
        if (root2==null) {
            return root1;
        }

        TreeNode merge=new TreeNode(root1.val+root2.val);
        merge.left=mergeTrees(root1.left,root2.left);
        merge.right=mergeTrees(root1.right,root2.right);
        return merge;

    }

}
