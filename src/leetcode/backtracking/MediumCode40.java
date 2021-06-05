package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode40 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        used = new boolean[candidates.length + 1];
        f(candidates, target, 0, new ArrayList<>(), new StringBuilder(), 0);
        return result;
    }

    // 暴力递归
    // 设置start避免结果重复，
    // 比如第一次调用递归是从0开始的，第一次计算完成之后，之后就是从1开始，避免结果重复
    public void f(int[] candidates, int target, int tempSum, List<Integer> temp, StringBuilder sb, int start) {
        if (target == tempSum) {

            result.add(new ArrayList<>(temp));

            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (tempSum + candidates[i] > target) {
                break;
            }
            // !used[i-1] 前面的 == 说明这两个元素是相同的
            // 如果这个数和之前的数一样，并且之前的数还未使用过（说明已经回溯过）
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            tempSum += candidates[i];
            temp.add(candidates[i]);
            used[i] = true;
            f(candidates, target, tempSum, temp, sb, i + 1);
            tempSum -= candidates[i];
            if (temp.size() > 0) {
                temp.remove(temp.size() - 1);
            }
            used[i] = false;

        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new MediumCode40().combinationSum2(candidates, 8));
    }
}
