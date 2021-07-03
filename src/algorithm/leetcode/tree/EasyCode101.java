package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : LoneKing
 * @Date : 2021/6/25
 */
public class EasyCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return f(root.left, root.right);
    }

    public boolean f(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null || left != null && right == null) {
            return false;
        }
        if (left.val == right.val) {
            boolean leftResult = f(left.left, right.right);
            boolean rightResult = f(left.right, right.left);
            return leftResult && rightResult;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] firstTree = {1, 2, 3, 0, 0, 4, 0, 0, 2, 4, 0, 0, 3, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);

        System.out.println(new EasyCode101().isSymmetric(tree));
    }
}
