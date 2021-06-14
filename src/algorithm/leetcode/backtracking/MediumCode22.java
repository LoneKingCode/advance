package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        //    f(n, 0, 0, new StringBuilder());
        f(n, 0, 0, "");
        return result;
    }

    public void f(int n, int leftCount, int rightCount, String temp) {
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount + rightCount == n << 1) {
            result.add(temp);
            return;
        }

        if (leftCount >= rightCount) {
            // 补一个左就立马补一个右，左够n个时候递归退出一层
            f(n, leftCount + 1, rightCount, temp + "(");
            // 然后又继续补右
            f(n, leftCount, rightCount + 1, temp + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new MediumCode22().generateParenthesis(3));
    }
}
