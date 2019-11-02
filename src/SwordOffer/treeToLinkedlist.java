package SwordOffer;

import java.util.ArrayList;

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

