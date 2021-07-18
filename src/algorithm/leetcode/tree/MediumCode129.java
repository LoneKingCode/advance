package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzixiang
 * @date 2021/7/17
 */
public class MediumCode129 {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append(root.val);

        helper(result, root, temp);

        return sum;
    }

    public void helper(List<String> result, TreeNode node, StringBuilder temp) {
        if (node == null) {
            return;
        }
        // 终止条件
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(temp.toString());
            return;
        }
        if (node.left != null) {
            temp.append(node.left.val);
            helper(result, node.left, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (node.right != null) {
            temp.append(node.right.val);
            helper(result, node.right, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] firstTree = {1, 2, 0, 0, 3, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);
        System.out.println(new MediumCode129().sumNumbers(tree));
    }
}
