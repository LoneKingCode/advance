package SwordOffer;

//根据先序遍历，后序遍历 重建二叉树
public class reConstructBinaryTreeMain {
    private int index;
    private boolean[] used;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        index = 0;
        used = new boolean[pre.length];
        TreeNode node = new TreeNode(0);
        create(node, pre, in);
        return node;
    }

    //    以“先序遍历”的顺序为准来创建树节点，index记录到哪个元素,used记录元素索引是否被使用。
//    每要添加节点时，判断这个元素值在中序遍历中的位置。
//    添加左节点：左边有元素且此左元素未被之前先序遍历中所使用
//    添加右节点：右边有元素且此左元素未被之前先序遍历中所使用
    private void create(TreeNode node, int[] pre, int[] in) {
        if (index > pre.length - 1) {
            return;
        }
        node.val = pre[index];
        used[index] = true;
        int midPos = getElementPosition(in, node.val);
        if (midPos > 0) {
            if (!used[getElementPosition(pre, in[midPos - 1])]) {
                node.left = new TreeNode(0);
                index++;
                create(node.left, pre, in);
            }
        }
        if (midPos < in.length - 1) {
            if (!used[getElementPosition(pre, in[midPos + 1])]) {
                node.right = new TreeNode(0);
                index++;
                create(node.right, pre, in);
            }
        }
    }

    private int getElementPosition(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
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