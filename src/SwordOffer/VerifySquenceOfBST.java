package SwordOffer;

/**
 * 题目：二叉搜索树的后序遍历序列
 * 描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：
 * 从前往后，如果遇到一个比最后一个元素大的节点，则说明他前面的都要“小于”他
 * 并且他后面到最后一个元素之间的节点，都要“大于”他
 * 二叉搜索树 左节点小于根节点 右节点大于根节点
 * 12
 * 5       18
 * 4   7   15  19
 * 后序遍历为 4 7 5 15 19 18 12
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        int last = sequence[sequence.length - 1];
        for (int i = 0; i < sequence.length - 1; i++) {
            //如果大于最后一个节点
            if (sequence[i] > last) {
                //则它前面都必定小于最后节点
                for (int j = 0; j < i; j++) {
                    //出现大于则不符合
                    if (sequence[j] > last) {
                        return false;
                    }
                }
                //且他后面到最后一个元素之间的节点，都要“大于”他
                for (int k = i+1; k < sequence.length - 1; k++) {
                    //出现小于则不符合
                    if (sequence[k] < sequence[i]) {
                        return false;
                    }
                }
                //检查过一次符合条件的即可
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
