package algorithm.tree;

public class treeCreateAndReverse {

    private static int index;

    public static void main(String[] args) {
        index = 0;
        //先序
        int[] firstTree = {1, 2, 4, 0, 0, 5, 0, 0, 3, 6, 0, 0, 7, 0, 0};
        TreeNode firstNode = new TreeNode(-1);
        createTreeFirst(firstNode, firstTree);
        index = 0;
        System.out.println("中序遍历");
        traverseMid(firstNode);
        System.out.println("\n先序遍历");
        traverseFirst(firstNode);
        System.out.println("\n后序遍历");
        traverseLast(firstNode);
    }

    //中序遍历二叉树
    public static void traverseMid(TreeNode node) {
        if (node == null) return;
        traverseMid(node.left);
        System.out.print(node.val);
        traverseMid(node.right);
    }

    //先序遍历二叉树
    public static void traverseFirst(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val);
        traverseFirst(node.left);
        traverseFirst(node.right);

    }

    //后序遍历二叉树
    public static void traverseLast(TreeNode node) {
        if (node == null) return;
        traverseFirst(node.left);
        traverseFirst(node.right);
        System.out.print(node.val);
    }


    //中序创建二叉树
    public static void createTreeMid(TreeNode node, int[] tree) {

    }

    // 先序创建二叉树
    public static void createTreeFirst(TreeNode node, int[] tree) {

        if (tree[index] == 0) {
            index++;
            return;
        }

        node.val = tree[index];
        node.left = new TreeNode(0);
        node.right = new TreeNode(0);

        if (tree[index + 1] == 0) {
            node.left = null;
            index++;
        } else {
            index++;
            createTreeFirst(node.left, tree);
        }

        if (tree[index + 1] == 0) {
            node.right = null;
            index++;
        } else {
            index++;
            createTreeFirst(node.right, tree);
        }
    }
}

