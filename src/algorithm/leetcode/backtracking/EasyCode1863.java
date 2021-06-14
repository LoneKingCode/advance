package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有子集的异或总和再求和
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 * <p>
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 * <p>
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 * <p>
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/5/25
 */
public class EasyCode1863 {


    /**
     * 提示 1
     * 一个长度为 n的数组nums 有 2^n2 个子集（包括空集与自身）。我们可以将这些子集一一映射到 [0, 2^n-1] 中的整数。
     * 提示 2
     * <p>
     * 数组中的每个元素都有「选取」与「未选取」两个状态，可以对应一个二进制位的 1与0。
     * 那么对于一个长度为 n 的数组nums，我们也可以用 n 个二进制位的整数来唯一表示每个元素的选取情况。
     * 此时该整数第 j 位的取值表示数组第 j 个元素是否包含在对应的子集中。
     * 思路与算法
     * 我们也可以用迭代来实现子集枚举。
     * <p>
     * 根据 提示 1 与 提示 2，我们枚举 [0, 2^n-1]中的整数 i，其第 j 位的取值表示
     * nums 的第 j 个元素是否包含在对应的子集中。
     * 对于每个整数 ii，我们遍历它的每一位计算对应子集的异或总和，并维护这些值之和。
     * <p>
     * i:    2n-1         j 0 1 2
     * 1 << n             1 << j
     * 0 00000000		   00000001 00000010 00000100    0 0 0
     * 1 00000001         00000001 00000010 00000100    T 0 0
     * 2 00000010		   00000001 00000010 00000100    0 T 0
     * 3 00000011         00000001 00000010 00000100    T T 0
     * 4 00000100         00000001 00000010 00000100    0 0 T
     * 5 00000101         00000001 00000010 00000100    T 0 T
     * 6 00000110		   00000001 00000010 00000100    0 T T
     * 7 00000111		   00000001 00000010 00000100    T T T
     *
     * @param nums
     * @return
     */
    public int subsetXORSum2(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    temp ^= nums[j];
                }
            }
            res += temp;
        }
        return res;
    }

    int result;

    public int subsetXORSum3(int[] nums) {
        dfs3(nums, 0, 0);
        return result;
    }

    public void dfs3(int[] nums, int current, int n) {
        if (n == nums.length) {
            result += current;
            return;
        }
        dfs3(nums, current ^ nums[n], n + 1);
        dfs3(nums, current, n + 1);
    }

    public int subsetXORSum(int[] nums) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0, new ArrayList<>());
        int sum = 0;
        for (ArrayList<Integer> list : result) {
            int temp = 0;
            for (Integer n : list) {
                temp ^= n;
            }
            sum += temp;
        }
        return sum;
    }

    /**
     * 回溯法，暴力，找到所有的子集
     *
     * @param nums
     * @param result
     * @param n
     * @param list
     */
    public static void dfs(int[] nums, List<ArrayList<Integer>> result, int n, List<Integer> list) {
        if (n == nums.length) {
            return;
        }
        list.add(nums[n]);
        result.add(new ArrayList<>(list));

        dfs(nums, result, n + 1, list);
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
        dfs(nums, result, n + 1, list);
    }

    public static void main(String[] args) {
        System.out.println(new EasyCode1863().subsetXORSum3(new int[]{5, 1, 6}));
    }
}
