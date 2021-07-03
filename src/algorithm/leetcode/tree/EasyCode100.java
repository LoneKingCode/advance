package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : LoneKing
 * @Date : 2021/6/19
 */
public class EasyCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return f(p, q);
    }

    public boolean f(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }

        if (p.val == q.val) {
            boolean leftResult = f(p.left, q.left);
            boolean rightResult = f(p.right, q.right);
            return leftResult && rightResult;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.right = new TreeNode(2);
        tree1.right.left = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.right = new TreeNode(2);
        tree2.right.left = new TreeNode(3);
        System.out.println(new EasyCode100().isSameTree(tree1, tree2));
    }
}