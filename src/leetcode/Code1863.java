package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有子集的异或总和再求和
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 * <p>
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
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
public class Code1863 {
    public int subsetXORSum2(int[] nums){
        int sum = 0;




        return sum;
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
     * 找到所有的子集
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
        System.out.println(new Code1863().subsetXORSum(new int[]{5, 1, 6}));
    }
}
