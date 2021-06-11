package algorithm.old.SwordOffer;

import java.util.ArrayList;
/**
 * 题目：二叉搜索树与双向链表
 * 描述: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：对于二叉搜索树，中序遍历，遍历序列即为从小到大的一个序列，
 *      将序列放入ArrayLit，然后再设置节点的left和right即可，注意边界。
 */
public class treeToLinkedlist {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        ArrayList<TreeNode> traverseMidTree = new ArrayList<>();
        traverseMid(pRootOfTree, traverseMidTree);
        for (int i = 0; i < traverseMidTree.size(); i++) {
            if (i > 0)
                traverseMidTree.get(i).left = traverseMidTree.get(i - 1);
            if (i + 1 < traverseMidTree.size())
                traverseMidTree.get(i).right = traverseMidTree.get(i + 1);
        }
        return traverseMidTree.get(0);
    }

    public void traverseMid(TreeNode tree, ArrayList<TreeNode> result) {
        if (tree == null) return;
        traverseMid(tree.left, result);
        result.add(tree);
        traverseMid(tree.right, result);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(6);
        tree.left.left.left = new TreeNode(4);
        tree.right = new TreeNode(12);
        tree.right.right = new TreeNode(14);
        new treeToLinkedlist().Convert(tree);
    }

}

