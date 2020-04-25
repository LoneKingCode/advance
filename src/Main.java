import javax.sound.midi.Soundbank;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 题目：
 * 描述:
 * <p>
 * 思路：
 */
public class Main {
    static boolean[] used;

    public static int subsets(List<Integer> nums) {
        int result = 0;
        List<List<Integer>> res = new ArrayList<>();
        used = new boolean[nums.size()];
        backtrack(0, nums, res, new ArrayList<Integer>());
        for (List<Integer> list : res) {
            if (list.size() == 0) continue;
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    continue;
                } else if (((double) list.get(i) / (double) i > list.get(i) / i)) {
                    flag = false;
                }
            }
            if (flag) {
                result++;
            }

        }
        return result;
    }

    private static void backtrack(int i, List<Integer> nums, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int j = i; j < nums.size(); j++) {
            if (!used[j]) {
                used[j] = true;
                temp.add(nums.get(j));
                backtrack(j + 1, nums, res, temp);
                temp.remove(temp.size() - 1);
                used[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num;
        num = cin.nextInt();
        List<Integer> list = new ArrayList<>();
        while (cin.hasNextInt()) {
            list.add(cin.nextInt());
        }
        System.out.println(subsets(list));
    }
}

