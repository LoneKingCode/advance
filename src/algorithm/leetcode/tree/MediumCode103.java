package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wangzixiang
 * @date 2021/7/17
 */
public class MediumCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0, true);
        return result;
    }

    public void helper(List<List<Integer>> result, TreeNode node, int height, boolean left) {
        if (node == null) {
            return;
        }
        if (result.size() <= height) {
            result.add(new ArrayList<>());
        }
        if (left) {
            result.get(height).add(node.val);
        } else {
            result.get(height).add(0, node.val);
        }
        helper(result, node.left, height + 1, !left);
        helper(result, node.right, height + 1, !left);
    }


    public static void main(String[] args) {
        int[] firstTree = {3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);
        System.out.println(new MediumCode103().zigzagLevelOrder(tree));
    }
}
