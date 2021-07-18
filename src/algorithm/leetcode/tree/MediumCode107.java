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
public class MediumCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0,row);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] firstTree = {3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};
        TreeNode tree = new TreeNode();
        treeCreateAndReverse.createTreeFirst(tree, firstTree);
        System.out.println(new MediumCode107().levelOrderBottom(tree));
    }
}
