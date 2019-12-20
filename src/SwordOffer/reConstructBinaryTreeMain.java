package SwordOffer;

import java.util.HashMap;

/**
 * 题目：重建二叉树
 * 介绍：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：
 * 以“先序遍历”的顺序为准来创建树节点，index记录到哪个元素,used记录元素索引是否被使用。
 * 每要添加节点时，判断这个元素值在中序遍历中的位置。
 * 添加左节点：左边有元素且此左元素未被先序遍历中所使用
 * 添加右节点：右边有元素且此左元素未被先序遍历中所使用
 */
public class reConstructBinaryTreeMain {
    private int index;
    private boolean[] used;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        index = 0;
        used = new boolean[pre.length];
        TreeNode node = new TreeNode(0);
        //建立 元素值:位置 的map，便于获取元素位置
        java.util.HashMap<Integer, Integer> preMap = new HashMap<>();
        java.util.HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            preMap.put(pre[i], i);
            inMap.put(in[i], i);
        }
        create(node, pre, in, inMap, preMap);
        return node;
    }


    private void create(TreeNode node, int[] pre, int[] in, HashMap<Integer, Integer> inMap, HashMap<Integer, Integer> preMap) {
        if (index > pre.length - 1) {
            return;
        }
        node.val = pre[index];
        //先序该元素设置为已使用
        used[index] = true;
        //该元素在中序遍历中的位置
        int midPos = inMap.get(node.val);
        //左边有元素 且 此左元素未被先序遍历中所使用
        if (midPos > 0 && !used[preMap.get(in[midPos - 1])]) {
            node.left = new TreeNode(0);
            index++;
            create(node.left, pre, in, inMap, preMap);
        }
        //右边有元素 且 此左元素未被先序遍历中所使用
        if (midPos < in.length - 1 && !used[preMap.get(in[midPos + 1])]) {
            node.right = new TreeNode(0);
            index++;
            create(node.right, pre, in, inMap, preMap);
        }
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] mid = {4, 2, 5, 1, 6, 3, 7};
        new reConstructBinaryTreeMain().reConstructBinaryTree(pre, mid);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}