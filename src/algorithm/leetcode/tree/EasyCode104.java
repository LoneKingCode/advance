package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @author : LoneKing
 * @Date : 2021/6/25
 */
public class EasyCode104 {
    int depth = 0;

    public int maxDepth(TreeNode root) {
        f(root, 0);
        return depth;
    }

    public void f(TreeNode tree, int currentDepth) {
        depth = Math.max(depth, currentDepth);
        if (tree == null) {
            return;
        }
        f(tree.left, currentDepth + 1);
        f(tree.right, currentDepth + 1);
    }

    public static void main(String[] args) {
        int[] firstTree = {3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);

        System.out.println(new EasyCode104().maxDepth(tree));
    }
}
