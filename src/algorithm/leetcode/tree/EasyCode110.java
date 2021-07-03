package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *  
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : LoneKing
 * @Date : 2021/6/26
 */
public class EasyCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int maxLeftDepth = depth(root.left);
        int maxRightDepth = depth(root.right);

        return Math.abs(maxLeftDepth - maxRightDepth) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int leftDepth = depth(tree.left);
        int rightDepth = depth(tree.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        int[] firstTree = {1, 2, 3, 4, 0, 0, 0, 0, 2, 0, 3, 0, 4, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);
        System.out.println(new EasyCode110().isBalanced(tree));
    }
}
