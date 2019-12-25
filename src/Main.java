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

/**
 * 题目：二叉搜索树的后序遍历序列
 * 描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *      如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：
 * 二叉搜索树 左节点小于根节点 右节点大于根节点
 *           12
 *       5       18
 *     4   7   15  19
 * 后序遍历为 4 7 5 15 19 18 12
 */
public class Main {
    public boolean VerifySquenceOfBST(int [] sequence) {

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
