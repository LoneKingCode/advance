import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;


public class Main {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result = new ArrayList<>();
        if (root == null) return result;
        find(root, target, 0, new ArrayList<Integer>());
        return result;
    }

    public void find(TreeNode node, int target, int current, ArrayList<Integer> temp) {
        if (target == current) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (node == null || current + node.val > target) {
            return;
        }

        if (node.left != null) {
            temp.add(node.val);

            find(node.left, target, current + node.val, temp);
            temp.remove(temp.size() - 1);
        }
        if (node.right != null) {
            temp.add(node.val);
            find(node.right, target, current + node.val, temp);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(3);
        tree.right = new TreeNode(4);
        tree.right.right = new TreeNode(1);
        System.out.println(new Main().FindPath(tree, 6));
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
