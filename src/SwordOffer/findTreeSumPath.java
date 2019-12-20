package SwordOffer;

import java.util.ArrayList;
import java.util.List;

public class findTreeSumPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return result;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        find(root, target, root.val, temp);
        return result;
    }

    private void find(TreeNode node, int target, int currentSum, List<Integer> temp) {
        if (currentSum == target && node.left == null && node.right == null) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (node != null) {
            if (node.left != null) {
                if (node.left.val + currentSum <= target) {
                    currentSum += node.left.val;
                    temp.add(node.left.val);
                    find(node.left, target, currentSum, temp);
                    currentSum -= node.left.val;
                    temp.remove(temp.size() - 1);
                }

            }
            if (node.right != null) {
                if (node.right.val + currentSum <= target) {
                    currentSum += node.right.val;
                    temp.add(node.right.val);
                    find(node.right, target, currentSum, temp);
                    currentSum -= node.right.val;
                    temp.remove(temp.size() - 1);
                }

            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(12);
        node.right.left = new TreeNode(4);
    }
}