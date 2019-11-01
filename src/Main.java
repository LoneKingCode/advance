import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }



    }

    public static void main(String[] args) {

        System.out.println(new Main().HasSubtree(node, node1));
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