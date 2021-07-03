package algorithm.leetcode.backtracking;

import java.util.*;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangzixiang
 * @date 2021/6/14
 */
public class MediumCode131 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return result;
        }

        f(s, 0, new LinkedList<>());
        return result;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i != j && i < s.length() && j >= 0) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void f(String s, int start, LinkedList<String> temp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                temp.add(str);f(s, i + 1, temp);
                temp.removeLast();
            }

        }
    }

    public static void main(String[] args) {

        System.out.println(new MediumCode131().partition("aab"));
    }
}
