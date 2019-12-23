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
//    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
//        if (root1 == null || root2 == null) return false;
//        return check(root1, root2);
//    }
//
//    private boolean check(TreeNode root1, TreeNode root2) {
//        if (root2 == null) return true;
//        if (root1 == null || root1.val != root2.val) return false;
//        return check(root1.left, root2.left) && check(root1.right, root2.right);
//    }

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
