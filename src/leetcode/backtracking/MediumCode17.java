package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/5/29
 */
public class MediumCode17 {

    String[][] keys = {
            {""},
            {""},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.isEmpty()) {
            return result;
        }
        f(0, digits, new StringBuilder());
        return result;
    }

    public void f(int index, String digits, StringBuilder temp) {

        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String[] keyLetters = keys[digits.charAt(index) - '0'];

        for (int i = 0; i < keyLetters.length; i++) {
            temp.append(keyLetters[i]);
            f(index + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MediumCode17().letterCombinations("23"));
    }
}
