package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/19
 */
public class MediumCode216 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        f(k, n, 0, new LinkedList<>(), 1);
        return result;
    }

    public void f(int k, int n, int sum, LinkedList<Integer> temp, int i) {
        if (n == sum && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (i > 9 || temp.size() > k) {
            return;
        }
        temp.add(i);
        f(k, n, sum + i, temp, i + 1);
        temp.removeLast();
        f(k, n, sum, temp, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(new MediumCode216().combinationSum3(3, 9));
    }
}
