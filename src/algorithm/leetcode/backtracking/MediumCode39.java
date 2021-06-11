package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode39 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        f(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    // 暴力递归
    // 设置start避免结果重复，
    // 比如第一次调用递归是从0开始的，第一次计算完成之后，之后就是从1开始，避免结果重复
    public void f(int[] candidates, int target, int tempSum, List<Integer> temp, int start) {
        if (target == tempSum) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (tempSum + candidates[i] > target) {
                break;
            }
            tempSum += candidates[i];
            temp.add(candidates[i]);
            f(candidates, target, tempSum, temp, i);
            tempSum -= candidates[i];
            if (temp.size() > 0) {
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        System.out.println(new MediumCode39().combinationSum(candidates, 8));
    }
}
