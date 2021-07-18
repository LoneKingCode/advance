package algorithm.leetcode.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.treeCreateAndReverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wangzixiang
 * @date 2021/7/17
 */
public class MediumCode102 {

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, TreeNode node, int height) {
        if (node == null) {
            return;
        }
        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(node.val);
        helper(result, node.left, height + 1);
        helper(result, node.right, height + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (treeNodeQueue.size() > 0) {
            List<Integer> row = new ArrayList<>();
            int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = treeNodeQueue.poll();
                row.add(node.val);
                if (Objects.nonNull(node.left)) {
                    treeNodeQueue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    treeNodeQueue.offer(node.right);
                }
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] firstTree = {3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);
        System.out.println(new MediumCode102().levelOrder1(tree));
    }
}
