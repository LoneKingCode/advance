package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author : LoneKing
 * @Date : 2021/6/19
 */
public class EasyCode94 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        f(root);
        return result;
    }

    public void f(TreeNode node) {
        if (node == null) {
            return;
        }
        f(node.left);
        result.add(node.val);
        f(node.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        System.out.println(new EasyCode94().inorderTraversal(tree));
    }
}
