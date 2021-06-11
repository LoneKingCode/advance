package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode77 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        f(n, k, new ArrayList<>(), 1);
        return result;
    }

    public void f(int n, int k, List<Integer> temp, int start) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 剪枝 去掉无用循环
        if (n - start + 1 < k - temp.size()) {
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            f(n, k, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new MediumCode77().combine(12, 3));
        System.out.println(System.nanoTime() - start);
    }
}
