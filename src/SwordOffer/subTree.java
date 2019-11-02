package SwordOffer;

public class subTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            if (contain(root1, root2))
                return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean contain(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null || node1.val != node2.val) return false;
        return contain(node1.left, node2.left) && contain(node1.right, node2.right);
    }

    public static void main(String[] args) {

      //  System.out.println(new subTree().HasSubtree(node, node1));
    }

}
