package SwordOffer;

import java.util.ArrayList;
import java.util.List;
/**
 * 题目：二叉树中和为某一值的路径
 * 描述:输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 思路：注意这个题意思是根节点到最末尾结点之间的路径的和，不是根节点到中间节点之间的路径
 * 用回溯法
 * 尝试累加左节点，然后"恢复状态"，然后尝试累加右节点,然后"恢复状态"
 * 递归的终止条件很关键，这这道题里是
 * current == target && node.left==null && node.right==null
 */
public class findTreeSumPath {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        //先把头节点放入temp中，便于递归中直接用node.left/right开始运算
        find(root, target, root.val, temp);
        return result;
    }

    public void find(TreeNode node, int target, int current, ArrayList<Integer> temp) {
        //和相等，并且这个node没有左右节点了
        if (target == current && node.left == null && node.right == null) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (node == null) {
            return;
        }
        //如果左节点值累加后<=目标值 才继续递归，不然没必要
        if (node.left != null && node.left.val + current <= target) {
            //添加到结果集合中
            temp.add(node.left.val);
            find(node.left, target, current + node.left.val, temp);
            //恢复状态，清除掉上面添加的
            temp.remove(temp.size() - 1);
        }
        if (node.right != null && node.right.val + current <= target) {
            temp.add(node.right.val);
            find(node.right, target, current + node.right.val, temp);
            temp.remove(temp.size() - 1);
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