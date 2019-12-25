package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：从上往下打印二叉树
 * 描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：利用队列Queue，先进先出，树的左结点，右结点依次加入到队列中
 * queue的offer和add区别，队列元素满时add会抛异常，而offer只会返回false
 */
public class PrintFromTopToBottomTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);

        }
        return result;
    }


    public static void main(String[] args) {

    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
