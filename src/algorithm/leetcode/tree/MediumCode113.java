package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author wangzixiang
 * @date 2021/7/17
 */
public class MediumCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        temp.add(root.val);
        helper(result, temp, root, targetSum, root.val);
        return result;
    }

    public void helper(List<List<Integer>> result, LinkedList<Integer> temp, TreeNode node, int targetSum, int sum) {
        if (sum == targetSum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (node == null) {
            return;
        }

        if (node.left != null) {
            temp.add(node.left.val);
            helper(result, temp, node.left, targetSum, sum + node.left.val);
            temp.removeLast();
        }
        if (node.right != null) {
            temp.add(node.right.val);
            helper(result, temp, node.right, targetSum, sum + node.right.val);
            temp.removeLast();
        }
    }


    public static void main(String[] args) {
        //int[] firstTree = {5, 4, 11, 7, 0, 0, 2, 0, 0, 0, 8, 13, 0, 0, 4, 5, 0, 0, 1, 0, 0}; 22
        int[] firstTree = {-2,0,-3,0,0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);
        System.out.println(new MediumCode113().pathSum(tree, -5));
    }
}
