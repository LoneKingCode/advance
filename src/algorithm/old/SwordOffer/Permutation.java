package algorithm.old.SwordOffer;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目：字符串的排列
 * 描述:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 思路：像回溯法，每个字符用过后就在used[]中设置为已使用
 *      然后从头遍历把用过字符之外的再追加到进来
 *      题中庸了TreeSet是为了去重复
 */
public class Permutation {

    Set<String> result = new TreeSet<>();
    boolean[] used;

    public ArrayList<String> Permutation(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        used = new boolean[str.length()];
        Permutation(str, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void Permutation(String str, StringBuilder temp) {
        if (temp.length() == str.length()) {
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i]) {
                continue;
            }
            temp.append(str.charAt(i));
            //当前字符设置为已使用
            used[i] = true;
            Permutation(str, temp);
            //恢复状态
            used[i] = false;
            temp.deleteCharAt(temp.length() - 1);

        }
    }


    public static void main(String[] args) {

        System.out.println(new Permutation().Permutation("abc"));
    }

}

