package SwordOffer;
/**
 * 题目：树的子结构
 * 描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：首先拿子树B的头结点去和树A的各个结点去比较，为了找到要开始比较的位置
 *  如果发现树A某结点和子树B头结点一样了
 *  就要调用contain递归方法去完整比较子树结构了
 */
public class subTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        //找到要开始比较的起始结点位置
        if (root1.val == root2.val) {
            if (contain(root1, root2))
                return true;
        }
        //左，右继续进行
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean contain(TreeNode node1, TreeNode node2) {
        //当root2为null时，代表没有子树的结点都比较完了，就代表包含
        if (node2 == null) return true;
        if (node1 == null || node1.val != node2.val) return false;
        return contain(node1.left, node2.left) && contain(node1.right, node2.right);
    }

    public static void main(String[] args) {

      //  System.out.println(new subTree().HasSubtree(node, node1));
    }

}
